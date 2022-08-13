package com.yjzs.gold.user.controller;


import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import com.yjzs.gold.user.config.OssTemplate;
import com.yjzs.gold.utils.AppResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


/**
 * @author Tght
 */
@RestController
@RequestMapping("/files")
public class FileController {

    @Autowired
    OssTemplate ossTemplate;

    @Value("${server.port}")
    private String port;

    @Value("${file.ip}")
    private String ip;
    // private static final String ip = "localhost";

    /**
     * 富文本上传接口
     *
     * @param file
     * @return
     * @throws IOException
     */
    @CrossOrigin
    @PostMapping("/editor")
    public JSON editorUpload(MultipartFile file) throws IOException {
        //获取文件名称
        String originalFilename = file.getOriginalFilename();
        // 定义文件的唯一标识（前缀） uuid
        String uuid = IdUtil.fastSimpleUUID();
        // 文件的路径
        String rootFilePath = System.getProperty("user.dir") + "/src/main/resources/files/" + uuid + "_" + originalFilename;
        // hutool 提供的工具类,文件流需要抛出异常
        FileUtil.writeBytes(file.getBytes(), rootFilePath);
        // 返回结果URL
        String url = ip + ":" + port + "/files/" + uuid;
        JSONObject json = new JSONObject();
        json.set("errno", 0);
        JSONArray array = new JSONArray();
        JSONObject data = new JSONObject();
        array.add(data);
        data.set("url", url);
        json.set("data", array);

        return json;
    }


    @PostMapping("/upload")
    public AppResponse<Object> upload(@RequestParam("uploadfile") MultipartFile files) {

        try {
            String filename = files.getOriginalFilename();
            filename = UUID.randomUUID().toString().replaceAll("-", "") + "-" + filename;
            String filePath = ossTemplate.upload(filename, files.getInputStream());

            return AppResponse.ok(filePath);
        } catch (Exception e) {

            return AppResponse.fail(null);
        }
    }

    /**
     * 上传接口
     * @param file
     * @return
     * @throws IOException
     */
/*    @CrossOrigin
    @PostMapping("/upload")
    public AppResponse upload(MultipartFile file) throws IOException {
        //获取文件名称
        String originalFilename = file.getOriginalFilename();
        // 定义文件的唯一标识（前缀） uuid
        String uuid = IdUtil.fastSimpleUUID();
        // 文件的路径
        String rootFilePath = System.getProperty("user.dir") + "/src/main/resources/files/" + uuid + "_" + originalFilename;
        // hutool 提供的工具类,文件流需要抛出异常
        FileUtil.writeBytes(file.getBytes(),rootFilePath);
        // 返回结果URL
        return AppResponse.ok(ip + ":" + port + "/files/" + uuid);
    }*/

    /**
     * 下载接口
     * 用流的方式将文件输出到浏览器，来实现文件下载
     *
     * @param response
     * @return
     */
    @GetMapping("/{uuid}")
    public void getFiles(@PathVariable String uuid, HttpServletResponse response) {
        // 新建一个输出流对象
        OutputStream os;
        // 根路径，找到定义文件
        String basePath = System.getProperty("user.dir") + "/src/main/resources/files/";
        // 获取到根路径下面所有的文件名称
        List<String> fileNames = FileUtil.listFileNames(basePath);
        // 根据访问携带的uuid，来对应路径下找文件，再输出出来
        String avatar = fileNames.stream().filter(name -> name.contains(uuid)).findAny().orElse("");
        try {
            // 如果找到了对应文件，就说明文件是可以被下载的
            if (StrUtil.isNotEmpty(avatar)) {
                // 加请求头
                response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(avatar, "UTF-8"));
                response.setContentType("application/octet-stream");
                // 路径加文件名，通过文件路径读取文件字节流
                byte[] bytes = FileUtil.readBytes(basePath + avatar);
                // 通过输出流返回文件
                os = response.getOutputStream();
                os.write(bytes);
                os.flush();
                os.close();
            }
        } catch (Exception e) {
            System.out.println("文件下载失败");
        }
    }
}

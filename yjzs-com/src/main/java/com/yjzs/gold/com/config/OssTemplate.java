package com.yjzs.gold.com.config;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.PutObjectRequest;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.InputStream;


/**
 * @author Tght
 */
@Slf4j
@Data
@ToString
@Component
public class OssTemplate {
    /**
     * Endpoint以华东1（杭州）为例，其它Region请按实际情况填写。
     *
     * @Value("${oss.endpoint}") 然后再在类上加@Component 这样太麻烦了，多起来就很麻烦
     */
    @Value("${oss.endpoint}")
    String endpoint;
    /**
     * 阿里云账号AccessKey拥有所有API的访问权限，风险很高。
     * 强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
     */
    @Value("${oss.accessKeyId}")
    String accessKeyId;
    @Value("${oss.accessKeySecret}")
    String accessKeySecret;
    /**
     * 填写Bucket名称，例如 examplebucket。
     */
    @Value("${oss.bucketName}")
    String bucketName;

    /**
     * @param filename    文件名
     * @param inputStream String filePath = "D:\\Data\\static\\picture\\wallhaven-l3r32p.jpg";  new File(filePath);
     * @throws Exception
     */
    public String upload(String filename, InputStream inputStream) throws Exception {

        // 填写Object完整路径，例如exampledir/exampleobject.txt。Object完整路径中不能包含Bucket名称。
        String objectName = "headImg/" + filename;
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        try {
            // 创建PutObjectRequest对象。
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, objectName, inputStream);
            // 如果需要上传时设置存储类型和访问权限，请参考以下示例代码。
//             ObjectMetadata metadata = new ObjectMetadata();
//             metadata.setHeader(OSSHeaders.OSS_STORAGE_CLASS, StorageClass.Standard.toString());
//             metadata.setObjectAcl(CannedAccessControlList.Private);
//             putObjectRequest.setMetadata(metadata);

            // 上传文件。
            ossClient.putObject(putObjectRequest);
            String fileuploadpath = "http://img.yjzs.gold/headImg/" + filename;
            log.debug("文件上传成功-{}", fileuploadpath);
            return fileuploadpath;
        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message:" + oe.getErrorMessage());
            System.out.println("Error Code:" + oe.getErrorCode());
            System.out.println("Request ID:" + oe.getRequestId());
            System.out.println("Host ID:" + oe.getHostId());
            log.debug("文件上传失败-{}", filename);
            return null;
        } catch (ClientException ce) {
            System.out.println("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message:" + ce.getMessage());
            log.debug("文件上传失败-{}", filename);
            return null;
        } finally {
            // return指令是最后执行的，如果return后面有表达式，则执行完表达式之后就执行finally中的语句，最后再执行return指令。
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
    }
}
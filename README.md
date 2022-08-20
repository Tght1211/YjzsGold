# 养基助手

### 1、修改gitignore文件生效

> 修改gitignore文件生效--
> 先前往项目根目录文件夹，右键 git bash

```shell
git rm -r --cached .
git add .
git commit -m 'update .gitignore'
```

### 2、服务信息

> 初始版本 20220813 毕业设计修订版

![image-20220813171600406](https://tght.oss-cn-beijing.aliyuncs.com/imgOSS/202208131716496.png)

### 3、打包信息

> 先install utils 再install feign-api
> 然后其他的四个服务就 package

### 4、jar包启动

> 上传到 /opt/Jar 或者 /www/tght 或者 /www/wcj

```shell
# 改名字
 mv yjzs-main.jar yjzs-main.jar20220821
# 杀进程
 ps -ef|grep java
 kill -9 进程号
# 启动
 nohup java -jar yjzs-main.jar &
# 看日志
 tail -f nohup.out 
```

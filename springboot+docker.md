## 1.如果只是单纯的跑一个boot不需要连数据库等，那么下面的方式非常简单快捷
1.编写Dockerfile
2.编写pom.xml
3.cd到项目路径 执行命令

```
#build
mvn clean package docker:build
#run
docker run -p 8081:8081 -t miozeng/boot2
#stop
docker stop miozeng/boot2
#remove container
docker rm miozeng/boot2
#remove images
docker rmi miozeng/boot2
```
具体参考https://github.com/miozeng/ms/blob/master/ms-eureka-server/docker.md

遇到异常 Connect to localhost:2375参考
https://stackoverflow.com/questions/39487399/docker-host-environment-variable-on-windows

## 2.使用springboot +mysql
### 1.mysql 容器
docker pull mysql (不指定版本会自动latest,但是我的环境最新的版本有点问题所以用了5.7)
运行
```
docker run --name mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -d mysql
docker run --name mysql57 -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -d mysql:5.7
```
-p:映射自己端口和容器端口		
--name:设置容器名字		
-eMYSQL_ROOT_PASSWORD：初始化root密码		
-d 后台运行		

进入mysql镜像中
docker exec -it mysql57  bash
查看mysql的启动状态
service mysql status
如果未启动则启动
service mysql start
查看数据库
show databases;
退出容器保持后台运行
Ctrl + P + Q 

### 2springboot
打包springboot 编写 Dockerfile,上传到linux
FROM java:8
VOLUME /tmp
ADD boot2.jar app.jar
RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]

cd到 Dockerfile 所在的目录
docker build -f Dockerfile -t  miozeng/boot2 /usr/dockerboot/boot2

启动
docker run -d -p 8081:8081 --name boot2 --link mysql57:mysql57  miozeng/boot2

## 3.使用tomcat+war+mysql
1.获取tomcat镜像

2.将war包copy到/usr/dockerfile/

3.执行
docker run -d -v /usr/dockerfile/prototype-user.war:/usr/local/tomcat/webapps/prototype-user.war -p 8080:8080  --name tomcat --link mysql57:mysql57  docker.io/tomcat  


## 4.使用docker compose

version: '3'
services:
  mysql:
   container_name:mysql57
   image: docker.io/mysql:5.7
   environment:
    MYSQL_DATABASE: mytest
    MYSQL_ROOT_PASSWORD: root
   ports:
   - "3306:3306"
   restart: always
   
  tomcat:
    restart: always
    build: ./boot2
    working_dir: /boot2
    volumes:
      - ./boot2:/boot2 
      - ~/.m2:/root/.m2
    expose:
      - "8080"
    command: mvn clean spring-boot:run
    depends_on:
      - nginx
      - mysql
        
 
 运行命令docker-compose up
 
## 常用命令整理
 启动docker 
systemctl start docker

查看docker信息
docker info

修改镜像中心
 /etc/docker/daemon.json 
{
  "registry-mirrors": ["https://zmwa1utj.mirror.aliyuncs.com"]
}

修改后重启服务
systemctl daemon-reload
systemctl restart docker

 进入容器镜像中
docker exec -it 容器name/id  bash
退出容器保持后台运行
Ctrl + P + Q 
查看容器日志
docker logs 容器名称

### docker中mysql数据库的数据导入和导出
导出数据
执行导出（备份）数据库命令：
假设容器名称未mysql 。而我们要备份的数据库就在里面，叫做 test_db。mysql 的用户名密码均为root，我们将文件备份到宿主机/opt/sql_bak文件夹下。
docker exec -it  mysql mysqldump -uroot -proot test_db > /opt/sql_bak/test_db.sql

导入数据
将宿主机上的数据sql复制到容器的文件下----因为是-v  启动  文件结构目录保持一致
docker cp /opt/gysql.sql  gysql （容器名称）:/opt/gysql.sql  
进入容器---》docker exec -it gysql （容器名称） bash
登录容器内的mysql数据库------》mysql -uroot -p123456
创建对象的数据库  create database somp;
使用use somp   --->执行 source  /opt/gysql.sql
exit;
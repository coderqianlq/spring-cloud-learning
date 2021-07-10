FROM frolvlad/alpine-oraclejdk8:slim
MAINTAINER qianlq "1242202279@qq.com"
VOLUME /tmp
COPY eureka-server-1.0.0-SNAPSHOT.jar eureka-server.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom"]
CMD ["-jar", "/eureka-server.jar"]
EXPOSE 8761
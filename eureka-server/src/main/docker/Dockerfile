FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD eureka-server-1.0.0-SNAPSHOT.jar eureka-server.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/eureka-server.jar"]
EXPOSE 8761
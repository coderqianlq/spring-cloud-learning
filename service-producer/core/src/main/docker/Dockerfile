FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD service-producer-core-2.3.0-SNAPSHOT.jar service-producer.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/service-producer.jar"]
EXPOSE 8100
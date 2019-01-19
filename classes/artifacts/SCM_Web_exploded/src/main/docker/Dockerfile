FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD scm-v1.0.jar scm.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/scm.jar"]
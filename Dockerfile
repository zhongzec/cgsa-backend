FROM openjdk:8-jdk-alpine
ARG JAR_FILE=web/build/libs/*.jar
VOLUME "/tmp"
EXPOSE 8080
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]

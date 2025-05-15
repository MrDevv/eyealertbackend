FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/eyealertbackend-0.0.1.jar
COPY ${JAR_FILE} app_eyealertbackend.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app_eyealertbackend.jar"]
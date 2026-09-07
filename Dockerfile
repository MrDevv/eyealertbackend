FROM eclipse-temurin:21-jdk-jammy
ARG JAR_FILE=target/eyealertbackend-0.0.1.jar
COPY ${JAR_FILE} api_eyealert.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "api_eyealert.jar"]
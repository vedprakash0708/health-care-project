FROM openjdk:17-slim
WORKDIR /app
COPY target/medicure-service-*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]

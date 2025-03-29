FROM openjdk:17-slim
WORKDIR /app
COPY target/medicure-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]

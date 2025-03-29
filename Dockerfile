FROM openjdk:17-slim
WORKDIR /app
COPY --chown=1000:1000 target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]

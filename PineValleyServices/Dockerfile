FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
RUN chmod +x ./gradelw && ./gradlew build
COPY build/libs/PineValleyServices-0.0.1-SNAPSHOT.jar app.jar
USER 10001
ENTRYPOINT ["java", "-jar", "/app.jar"]

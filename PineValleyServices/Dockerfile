FROM eclipse-temurin:17-jammy
VOLUME /tmp
COPY build/libs/PineValleyServices-0.0.1-SNAPSHOT.jar app.jar
USER 10001
ENTRYPOINT java -XX:+UseSerialGC -Xss512k -XX:MaxRAM=72m -jar /app.jar

FROM adoptopenjdk/openjdk11:alpine-jre
EXPOSE 9000
ARG JAR_FILE=device-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} device.jar
ENTRYPOINT ["java", "-jar", "/device.jar"]
FROM adoptopenjdk/openjdk11:alpine-jre
EXPOSE 9001
ARG JAR_FILE=analytics-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} analytics.jar
ENTRYPOINT ["java", "-jar", "/analytics.jar"]
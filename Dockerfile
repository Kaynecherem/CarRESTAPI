FROM openjdk:17-jdk
ENV JAVA_TOOL_OPTIONS="-XX:-UseContainerSupport"

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]

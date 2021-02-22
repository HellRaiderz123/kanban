FROM openjdk:8-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} kanban.jar
ENTRYPOINT ["sh", "-c", "java -jar /kanban.jar"]
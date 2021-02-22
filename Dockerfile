FROM openjdk:8-alpine
ADD target/kanban.jar kanban.jar
ENTRYPOINT ["sh", "-c", "java -jar /kanban.jar"]
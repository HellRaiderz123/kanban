FROM openjdk:8-alpine
ADD target/*.jar kanban.jar
ENTRYPOINT ["sh", "-c", "java -jar /kanban.jar"]
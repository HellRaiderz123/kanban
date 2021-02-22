FROM maven:3.6.3-jdk-8 AS MAVEN_TOOL_CHAIN
COPY pom.xml /tmp/
COPY src /tmp/src/
WORKDIR /tmp/
RUN mvn package
ENTRYPOINT ["sh", "-c", "java -jar /tmp/target/kanban.jar"]
EXPOSE 8080/tcp
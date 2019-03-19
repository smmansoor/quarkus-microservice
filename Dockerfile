
FROM openjdk:8-jre-slim

RUN mkdir /app
COPY target/lib /app/lib

COPY target/*-runner.jar /app/application.jar

EXPOSE 8080

CMD ["java","-Dquarkus.http.host=0.0.0.0", "-jar", "/app/application.jar"]

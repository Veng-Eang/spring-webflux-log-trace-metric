FROM eclipse-temurin:21-jre

WORKDIR /app

ADD target/app.jar app.jar
ADD target/opentelemetry-javaagent.jar opentelemetry-javaagent.jar

EXPOSE 8091

ENTRYPOINT ["java", "-javaagent:opentelemetry-javaagent.jar", "-jar", "app.jar"]
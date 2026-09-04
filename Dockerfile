FROM eclipse-temurin:21-jre

WORKDIR /app


COPY target/app.jar app.jar
COPY target/opentelemetry-javaagent.jar opentelemetry-javaagent.jar

EXPOSE 8091

#ENTRYPOINT ["java", "-jar", "app.jar"]
ENTRYPOINT java -javaagent:opentelemetry-javaagent.jar \
				-jar app.jar
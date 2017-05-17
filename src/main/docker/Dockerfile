FROM openjdk:8-alpine
VOLUME /tmp
ADD vibe-1.0-SNAPSHOT.jar app.jar
RUN sh -c 'touch /app.jar'
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]

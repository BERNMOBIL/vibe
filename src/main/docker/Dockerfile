FROM openjdk:8
VOLUME /tmp
ADD vibe-1.0-SNAPSHOT.jar app.jar
RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS="-Dserver.port=80"
CMD ["java", $JAVA_OPTS, "-jar", "app.jar"]
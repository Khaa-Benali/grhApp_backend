FROM alpine:latest

# Installation d'OpenJDK 17
RUN apk --no-cache add openjdk17-jre

# Exposer le port que l'application va utiliser
EXPOSE 8080
WORKDIR /app
COPY  target/demo.jar /app/demo.jar
# Démarrer l'application
ENTRYPOINT ["java", "-jar", "demo.jar" ]
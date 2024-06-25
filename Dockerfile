# Utilise une image de base Java
FROM openjdk:17-jdk-slim

# Exposer le port que l'application va utiliser
EXPOSE 8080
ADD target/demo.jar demo.jar
# Démarrer l'application
ENTRYPOINT ["java", "-jar", "/demo.jar"
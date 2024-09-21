# Utiliser une image de base avec OpenJDK 17
FROM openjdk:17-jdk-alpine

# Créer un répertoire pour l'application
WORKDIR /app
COPY build/libs/springtest-0.0.1-SNAPSHOT.jar app.jar

# Définir la commande d'entrée pour l'image Docker
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
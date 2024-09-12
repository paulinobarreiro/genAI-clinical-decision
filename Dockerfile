# Usar uma imagem base do OpenJDK
FROM openjdk:17-jdk-slim

# Configurar argumentos para personalização
ARG JAR_FILE=target/*.jar

# Copiar o JAR do projeto para o container
COPY ${JAR_FILE} app.jar

# Expôr a porta que a aplicação irá rodar
EXPOSE 8080

# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "/app.jar"]
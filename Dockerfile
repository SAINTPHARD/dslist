# Usa uma imagem base com o OpenJDK, uma versão leve do Java
FROM openjdk:17-jdk-slim

# Define um diretório de trabalho dentro do container
WORKDIR /app

# Copia o arquivo JAR da sua aplicação para o container
COPY target/*.jar app.jar

# Expõe a porta que a sua aplicação usa
EXPOSE 8080

# Define o comando que será executado quando o container for iniciado
ENTRYPOINT ["java", "-jar", "app.jar"]
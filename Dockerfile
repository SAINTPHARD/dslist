# =======================================================
# ESTÁGIO 1: Build (Compilação com Maven e JDK 21)
# =======================================================
FROM maven:3-openjdk-21 AS build

# Define o diretório de trabalho
WORKDIR /app

# Copia o pom.xml para baixar as dependências primeiro (cache)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copia o resto do código-fonte
COPY src ./src

# Compila o projeto e gera o arquivo .jar na pasta /app/target
RUN mvn clean package -DskipTests

# =======================================================
# ESTÁGIO 2: Run (Execução com JRE 21) - LINHA CORRIGIDA
# =======================================================
FROM openjdk:21-jre

# Define o diretório de trabalho
WORKDIR /app

# Copia o arquivo .jar gerado no estágio 'build' para a imagem final
COPY --from=build /app/target/*.jar app.jar

# Expõe a porta que a aplicação usa
EXPOSE 8080

# Comando para iniciar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]

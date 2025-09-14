# =======================================================
# ESTÁGIO 1: Build com Maven + JDK 21
# =======================================================
FROM maven:3.9-eclipse-temurin-21 AS build

WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# =======================================================
# ESTÁGIO 2: Run com Eclipse Temurin (JRE 21)
# =======================================================
FROM eclipse-temurin:21-jre

WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

# Expõe a porta (Railway vai substituir pelo $PORT)
EXPOSE 8080

# Inicia a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]

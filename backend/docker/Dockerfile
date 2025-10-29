# Etapa de build (gera o JAR)
FROM maven AS build
WORKDIR /backend
COPY .. .
RUN mvn clean package -DskipTests

# Etapa de execução
FROM eclipse-temurin:21-jdk
WORKDIR /backend
COPY --from=build /backend/target/*.jar backend.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "backend.jar"]

FROM eclipse-temurin:25-jdk AS createJar

WORKDIR /api
COPY . .

RUN chmod +x gradlew
RUN ./gradlew clean bootJar

FROM eclipse-temurin:25-jdk

WORKDIR /api
COPY --from=createJar /api/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
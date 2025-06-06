# Używamy oficjalnego obrazu Javy 21
FROM openjdk:21

# Ustawiamy katalog roboczy
WORKDIR /app

# Kopiujemy plik pom.xml i ściągamy zależności
COPY pom.xml mvnw mvnw.cmd /app/
COPY .mvn /app/.mvn
RUN chmod +x /app/mvnw
RUN /app/mvnw dependency:go-offline

# Kopiujemy cały projekt
COPY . /app/

# Budujemy aplikację
RUN /app/mvnw clean package -DskipTests

# Upewniamy się, że JAR faktycznie się skopiował
RUN ls -lah /app/target/

# Uruchamiamy aplikację
CMD ["java", "-jar", "/app/target/task-pilot-0.0.1-SNAPSHOT.jar"]

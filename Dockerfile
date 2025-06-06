FROM openjdk:17

WORKDIR /app

# Kopiujemy wrappera i pliki podstawowe
COPY .mvn .mvn
COPY mvnw pom.xml application/pom.xml task/pom.xml worklog/pom.xml ./

# Teraz kopiujemy resztę projektu (moduły muszą być dostępne!)
COPY . .

# Pobieramy zależności i budujemy
RUN chmod +x ./mvnw && ./mvnw clean package -DskipTests

# Uruchamiamy aplikację (zbudowany jar w application/target)
CMD ["java", "-jar", "application/target/application-0.0.1-SNAPSHOT.jar"]

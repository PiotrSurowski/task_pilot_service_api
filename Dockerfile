FROM openjdk:21

WORKDIR /app

# Kopiujemy wrappera i pliki potrzebne do budowy
COPY .mvn .mvn
COPY mvnw pom.xml ./

# Ustawiamy uprawnienia do wrappera Mavena
RUN chmod +x ./mvnw

# Pobieramy zależności (moduły już są dostępne)
RUN ./mvnw dependency:go-offline

# Kopiujemy resztę projektu
COPY . .

# Budujemy aplikację
RUN ./mvnw clean package -DskipTests

# Pokazujemy co jest w target
RUN ls -lah /app/**/target/

# Uruchamiamy główny JAR (zmodyfikuj nazwę jeśli inaczej się nazywa)
CMD ["java", "-jar", "application/target/application-0.0.1-SNAPSHOT.jar"]


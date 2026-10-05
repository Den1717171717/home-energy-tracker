# Home Energy Tracker

## Requirements

- Java 21
- Docker + Docker Compose

## Run

1. Start MySQL (from the project root):

   ```bash
   docker compose up -d
   ```

   MySQL 8.0 runs on `localhost:3306` with user `root` / password `password` and database `home_energy_tracker`.

2. Start the user service:

   ```bash
   cd user-service
   ./mvnw spring-boot:run
   ```

   The service runs on `http://localhost:8080`.

   The service needs database settings in `user-service/src/main/resources/application.properties`:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/home_energy_tracker
   spring.datasource.username=root
   spring.datasource.password=password
   ```

## Test

```bash
cd user-service
./mvnw test
```

## Stop

```bash
docker compose down        # keep data
docker compose down -v     # also delete the database volume
```

# Courier Tracking Application

With this application, the couriers' current location information and the store information they visit are kept and updated. In addition, the total distance covered by each courier is also obtained.

## Requirements

- Java 21
- Maven

## Running the Application

1. Clone the repository:

   git clone https://github.com/MustafaCemil/courier-tracking.git

2. Navigate to the project directory:
- cd courier-tracking

3. Build the project:
- mvn clean install

4. Run the application:
- mvn spring-boot:run

The application will start on http://localhost:8080.


## API Endpoints
# http://localhost:8080/swagger-ui/index.html

## H2 Console
# http://localhost:8080/h2-console

## Design Patterns
- Singleton: Used in @Service annotation to ensure a single instance of data.
- Builder:  Used the lombok library implement the builder design pattern."
- Observer: Used courier location update tables
- Strategy: LocationObserver is in the extended classes

## Notes
- Ensure the stores.json file is placed in the src/main/resources directory.
- This application uses H2 database for simplicity.
- When the project is started, couriers are automatically added under data.sql.

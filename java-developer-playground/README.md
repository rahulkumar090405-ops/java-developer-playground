# Java Developer Playground

A comprehensive Maven Spring Boot project for learning and practicing Java, Data Structures & Algorithms, and Spring Framework.

## Project Structure

The project is organized into several learning modules:

- **corejava**: Core Java concepts (OOP, abstraction, inheritance, polymorphism, exceptions, strings)
- **collections**: Java Collections Framework (List, Set, Map, Queue)
- **dsa**: Data Structures & Algorithms (arrays, sorting, searching, recursion, trees, graphs, dynamic programming, etc.)
- **multithreading**: Concurrency and multithreading concepts
- **javamodern**: Modern Java features (Java 8, 11, 17, 21)
- **jdbc**: JDBC fundamentals and database connectivity
- **spring**: Spring Framework concepts and Spring Boot
- **microservices**: Microservices patterns
- **systemdesign**: System design principles
- **codingchallenges**: Coding interview challenges
- **interviewquestions**: Common interview questions

## Tech Stack

- **Java**: 21
- **Spring Boot**: 3.4.x
- **Maven**: Build tool
- **PostgreSQL**: Database (optional)
- **JUnit**: Testing

## Prerequisites

- JDK 21 or later
- Maven 3.8.x or later
- VS Code with Java Extension Pack
- PostgreSQL (optional, for JDBC examples)

## Build and Run

### Build the project
```bash
mvn clean install
```

### Run the Spring Boot application
```bash
mvn spring-boot:run
```

### Run tests
```bash
mvn test
```

## Database Setup (Optional)

If you want to use the JDBC examples with PostgreSQL:

1. Install PostgreSQL
2. Create a database:
   ```sql
   CREATE DATABASE java_playground;
   ```
3. Update `src/main/resources/application.properties` with your database credentials
4. Set the environment variable:
   ```bash
   export DB_PASSWORD=your_password
   ```

## Package Naming Convention

All packages follow the naming convention: `com.javaplayground.*`

Examples:
- `com.javaplayground.dsa.arrays`
- `com.javaplayground.multithreading.threads`
- `com.javaplayground.jdbc.crud`
- `com.javaplayground.spring.boot`

## Project Goals

This playground is designed for:
- Learning core Java concepts
- Practicing Data Structures and Algorithms
- Understanding Spring Framework
- Preparing for technical interviews
- Exploring modern Java features

## License

MIT License

## Author

Java Developer

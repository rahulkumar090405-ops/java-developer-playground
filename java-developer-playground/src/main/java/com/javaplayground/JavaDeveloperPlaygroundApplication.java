package com.javaplayground;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main Spring Boot Application for Java Developer Playground
 * 
 * This is the entry point for the Spring Boot application.
 * The application can run without a PostgreSQL database connection,
 * though JDBC examples may fail if the database is not available.
 * 
 * Run the application with:
 *   mvn spring-boot:run
 * 
 * Or from Java:
 *   java -jar target/java-developer-playground-1.0.0.jar
 */
@SpringBootApplication
public class JavaDeveloperPlaygroundApplication {

    private static final Logger logger = LoggerFactory.getLogger(JavaDeveloperPlaygroundApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(JavaDeveloperPlaygroundApplication.class, args);
        logger.info("========================================");
        logger.info("Java Developer Playground Started!");
        logger.info("========================================");
        logger.info("Application is running on http://localhost:8080/api");
        logger.info("========================================");
    }
}

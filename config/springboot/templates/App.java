package com.dsa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import lombok.extern.slf4j.Slf4j;

/**
 * Main application class for the DSA Java Spring Boot application.
 * 
 * This class serves as the entry point for the Spring Boot application,
 * providing comprehensive configuration for the DSA platform including
 * algorithm management, data structures, user authentication, and API services.
 * 
 * @Complexity Time: O(1) - Application startup
 * @Complexity Space: O(1) - Application memory footprint
 * @Performance Optimized startup with lazy loading
 * @Stability Stable - Production ready
 * @Algorithm Spring Boot 3.2 application framework
 * @Implementation Spring Boot with comprehensive configuration
 * @Optimization Component scanning and auto-configuration
 * @Reference Spring Boot Documentation
 */
@Slf4j
@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.dsa.repositories")
@EntityScan(basePackages = "com.dsa.entities")
@ComponentScan(basePackages = "com.dsa.services,com.dsa.controllers,com.dsa.config")
@EnableCaching
@EnableAsync
@EnableScheduling
public class App {

    /**
     * Main method to start the Spring Boot application.
     * 
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        try {
            log.info("Starting DSA Java Spring Boot Application...");
            
            // Set system properties for JavaFX compatibility if needed
            System.setProperty("java.awt.headless", "false");
            System.setProperty("javafx.platform", "desktop");
            
            // Create and run Spring Boot application
            SpringApplication.run(App.class, args);
            
        } catch (Exception e) {
            log.error("Failed to start DSA Java Spring Boot Application", e);
            System.exit(1);
        }
    }
}

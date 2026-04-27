package com.dsa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.dsa.config.DsaProperties;
import com.dsa.config.SecurityConfig;

import lombok.extern.slf4j.Slf4j;

/**
 * Main Spring Boot application class for DSA Java Application.
 * 
 * This class serves as the entry point for the Spring Boot application,
 * providing comprehensive configuration for Data Structures and Algorithms
 * management, visualization, and analysis.
 * 
 * @Complexity Time: O(1) - Application startup
 * @Complexity Space: O(1) - Initial memory allocation
 * @Performance Optimized startup with lazy loading
 * @Stability Stable - Production ready
 * @Algorithm Spring Boot application framework
 * @Implementation Spring Boot 3.2 with Java 17
 * @Optimization Component scanning and configuration optimization
 * @Reference Spring Boot Documentation
 */
@Slf4j
@SpringBootApplication
@EnableConfigurationProperties(DsaProperties.class)
@EnableCaching
@EnableJpaAuditing
@EnableAsync
@EnableScheduling
public class DsaJavaApplication {

    /**
     * Main method to start the Spring Boot application.
     * 
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        try {
            // Log application startup
            log.info("Starting DSA Java Application...");
            
            // Set system properties for JavaFX if needed
            System.setProperty("java.awt.headless", "false");
            System.setProperty("javafx.platform", "desktop");
            
            // Create and run Spring Boot application
            SpringApplication app = new SpringApplication(DsaJavaApplication.class);
            
            // Configure application properties
            configureApplication(app, args);
            
            // Run the application
            app.run(args);
            
        } catch (Exception e) {
            log.error("Failed to start DSA Java Application", e);
            System.exit(1);
        }
    }

    /**
     * Configure the Spring Boot application with custom settings.
     * 
     * @param app The SpringApplication instance
     * @param args Command line arguments
     */
    private static void configureApplication(SpringApplication app, String[] args) {
        // Set default profile if not specified
        if (!containsProfile(args)) {
            app.setAdditionalProfiles("dev");
        }
        
        // Configure application properties
        app.getProperties().put("spring.application.name", "DSA Java Application");
        app.getProperties().put("spring.profiles.active", getActiveProfile(args));
        
        // Configure banner
        app.setBannerMode(org.springframework.boot.Banner.Mode.CONSOLE);
        
        // Configure web application type
        app.setWebApplicationType(org.springframework.boot.WebApplicationType.SERVLET);
        
        // Configure headless property for JavaFX compatibility
        System.setProperty("java.awt.headless", "false");
        
        log.info("Application configured with profile: {}", getActiveProfile(args));
    }

    /**
     * Check if command line arguments contain a profile specification.
     * 
     * @param args Command line arguments
     * @return true if profile is specified, false otherwise
     */
    private static boolean containsProfile(String[] args) {
        for (String arg : args) {
            if (arg.startsWith("--spring.profiles.active=") || 
                arg.startsWith("-Dspring.profiles.active=")) {
                return true;
            }
        }
        return false;
    }

    /**
     * Get the active profile from command line arguments.
     * 
     * @param args Command line arguments
     * @return The active profile name
     */
    private static String getActiveProfile(String[] args) {
        for (String arg : args) {
            if (arg.startsWith("--spring.profiles.active=")) {
                return arg.substring("--spring.profiles.active=".length());
            } else if (arg.startsWith("-Dspring.profiles.active=")) {
                return arg.substring("-Dspring.profiles.active=".length());
            }
        }
        return "dev";
    }
}

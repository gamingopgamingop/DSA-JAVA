package com.dsa;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * JavaFX Application Starter
 * DSA Java Algorithms - GUI Application
 */
public class DsaJavaApplication extends Application {
    
    private static final Logger LOGGER = Logger.getLogger(DsaJavaApplication.class.getName());
    
    /**
     * Default constructor for DSA Java Application
     */
    public DsaJavaApplication() {
        // Default constructor
    }
    
    @Override
    public void start(final Stage primaryStage) {
        // Create UI components
        final Label titleLabel = new Label("DSA Java Algorithms");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #2e86ab;");
        
        final Label descriptionLabel = new Label("Data Structures and Algorithms Learning Platform");
        descriptionLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: #666;");
        
        final Button algorithmsButton = new Button("View Algorithms");
        algorithmsButton.setStyle("-fx-background-color: #2e86ab; -fx-text-fill: white; -fx-font-size: 14px; -fx-padding: 10px 20px;");
        algorithmsButton.setOnAction(e -> {
            LOGGER.info("Algorithms button clicked!");
            // TODO: Navigate to algorithms view
        });
        
        final Button testingButton = new Button("Run Tests");
        testingButton.setStyle("-fx-background-color: #a23b72; -fx-text-fill: white; -fx-font-size: 14px; -fx-padding: 10px 20px;");
        testingButton.setOnAction(e -> {
            LOGGER.info("Testing button clicked!");
            // TODO: Navigate to testing view
        });
        
        // Create layout
        final VBox root = new VBox(20);
        root.setStyle("-fx-padding: 40px; -fx-alignment: center; -fx-background-color: #f8f9fa;");
        root.getChildren().addAll(
            titleLabel,
            descriptionLabel,
            algorithmsButton,
            testingButton
        );
        
        // Create scene and setup stage
        final Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("DSA Java Algorithms");
        primaryStage.setScene(scene);
        primaryStage.setResizable(true);
        primaryStage.show();
        
        LOGGER.info("DSA JavaFX Application started successfully!");
    }
    
    /**
     * Main method to launch the JavaFX application
     * 
     * @param args command line arguments
     */
    public static void main(final String[] args) {
        launch(args);
    }
}

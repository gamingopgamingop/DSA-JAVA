package com.dsa;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX Application Starter
 * DSA Java Algorithms - GUI Application
 */
public class App extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        // Create UI components
        Label titleLabel = new Label("DSA Java Algorithms");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #2e86ab;");
        
        Label descriptionLabel = new Label("Data Structures and Algorithms Learning Platform");
        descriptionLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: #666;");
        
        Button algorithmsButton = new Button("View Algorithms");
        algorithmsButton.setStyle("-fx-background-color: #2e86ab; -fx-text-fill: white; -fx-font-size: 14px; -fx-padding: 10px 20px;");
        algorithmsButton.setOnAction(e -> {
            System.out.println("Algorithms button clicked!");
            // TODO: Navigate to algorithms view
        });
        
        Button testingButton = new Button("Run Tests");
        testingButton.setStyle("-fx-background-color: #a23b72; -fx-text-fill: white; -fx-font-size: 14px; -fx-padding: 10px 20px;");
        testingButton.setOnAction(e -> {
            System.out.println("Testing button clicked!");
            // TODO: Navigate to testing view
        });
        
        // Create layout
        VBox root = new VBox(20);
        root.setStyle("-fx-padding: 40px; -fx-alignment: center; -fx-background-color: #f8f9fa;");
        root.getChildren().addAll(
            titleLabel,
            descriptionLabel,
            algorithmsButton,
            testingButton
        );
        
        // Create scene and setup stage
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("DSA Java Algorithms");
        primaryStage.setScene(scene);
        primaryStage.setResizable(true);
        primaryStage.show();
        
        System.out.println("DSA JavaFX Application started successfully!");
    }
    
    /**
     * Main method to launch the JavaFX application
     */
    public static void main(String[] args) {
        launch(args);
    }
}

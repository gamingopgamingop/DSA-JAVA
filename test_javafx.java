import javafx.application.Application;
import javafx.stage.Stage;

public class test_javafx extends Application {
    @Override
    public void start(Stage primaryStage) {
        System.out.println("JavaFX is working!");
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}

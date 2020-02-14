import View.MainMenuView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Stratego extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        MainMenuView view = new MainMenuView();
        Scene scene1 = new Scene(view);
        primaryStage.setTitle("Stratego");
        primaryStage.setScene(scene1);
       // scene1.getStylesheets().add(getClass().getResource("stratego.css").toExternalForm());
        primaryStage.setHeight(500);
        primaryStage.setWidth(600);
        primaryStage.show();
    }
}

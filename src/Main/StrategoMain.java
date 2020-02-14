package Main;

import View.MainMenuPresenter;
import View.MainMenuView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StrategoMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        MainMenuView view = new MainMenuView();
        StrategoMain model = new StrategoMain();
        MainMenuPresenter presenter = new MainMenuPresenter(model, view);

        Scene scene1 = new Scene(view);
        primaryStage.setTitle("Stratego");
        primaryStage.setScene(scene1);
        primaryStage.setHeight(500);
        primaryStage.setWidth(600);
        primaryStage.show();
    }
}

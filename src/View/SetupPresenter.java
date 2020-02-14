package View;

import Main.StrategoMain;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class SetupPresenter {
    private StrategoMain model;
    private SetupView view;

    public SetupPresenter(StrategoMain model, SetupView view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
        updateView();
    }

    private void updateView() {

    }

   private void addEventHandlers() {
        view.getBtnStandardConfig().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Are you sure you want to use the standard army configuration?", ButtonType.YES, ButtonType.NO);
                alert.showAndWait();
                if (alert.getResult() == ButtonType.YES) {
                    GameView gameView = new GameView();
                    GamePresenter presenter = new GamePresenter(model, gameView);
                    view.getScene().setRoot(gameView);
                }
                else{
                    alert.close();
                }
            }
        });
    }
}

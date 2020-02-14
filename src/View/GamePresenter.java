package View;

import Main.StrategoMain;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;


public class GamePresenter {
    private StrategoMain model;
    private GameView view;

    public GamePresenter(StrategoMain model, GameView view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
        updateView();
    }

    private void updateView() {
    }

    private void addEventHandlers() {
        view.getBtnPause().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Pause");
                alert.setHeaderText("What would you like to do:");
                alert.setContentText("Choose your option.");
                ButtonType btnPlay = new ButtonType("Play");
                ButtonType btnStop = new ButtonType("Stop");
                ButtonType btnSettings = new ButtonType("Settings");
                alert.getButtonTypes().setAll(btnPlay,btnSettings,btnStop);
                alert.showAndWait();
                if (alert.getResult() == btnPlay ){
                    alert.close();
                }else if (alert.getResult() == btnSettings){
                    SettingsView settingsView = new SettingsView();
                    SettingsPresenter settingsPresenter = new SettingsPresenter(model, settingsView);
                    view.getScene().setRoot(settingsView);
                }else if (alert.getResult() == btnStop) {
                    alert.close();
                    Alert alert1 = new Alert(Alert.AlertType.WARNING, "You are leaving the game, would you like to save", ButtonType.YES, ButtonType.NO);
                    alert1.showAndWait();
                    if (alert1.getResult() == ButtonType.YES) {
                        SaveView saveView = new SaveView();
                        SavePresenter savePresenter = new SavePresenter(model, saveView);
                        view.getScene().setRoot(saveView);
                    } else {
                        System.exit(0);
                    }
                }
            }
        });
    }
}


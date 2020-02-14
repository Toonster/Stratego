package View;


import com.sun.javafx.menu.MenuItemBase;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;


public class    MainMenuView extends GridPane {
    private ImageView imageView;
    private Button btnStartNew;
    private Button btnPlay;
    private Button btnSettings;
    private Button btnRules;
    private Button btnHighscores;
    private Label welcome;
    private Button btnQuit;

    public MainMenuView() {
        initialiseNodes();
        layoutNodes();
    }

    private void layoutNodes() {
        this.add(welcome, 2, 0,1,1);
        this.add(btnStartNew, 2, 1, 1,1);
        this.add(btnPlay, 2,2,1,1);
        this.add(btnSettings, 2, 3, 1,1);
        this.add(btnRules, 2, 4, 1,1);
        this.add(btnQuit, 2,5, 1, 1);
        this.setAlignment(Pos.CENTER);
        this.setVgap(20);
        btnStartNew.setMaxWidth(400);
        btnStartNew.setMinHeight(100);
        btnPlay.setMaxWidth(400);
        btnPlay.setMinHeight(100);
    }

    private void initialiseNodes() {
        btnStartNew = new Button("Start new game");
        btnStartNew.getStyleClass().addAll("startbtn");
        btnPlay = new Button("Continue game");
        btnPlay.getStyleClass().addAll("startbtn");
        btnSettings = new Button("Setttings");
        btnSettings.getStyleClass().addAll("startbtn");
        btnRules = new Button("Rules");
        btnRules.getStyleClass().addAll("startbtn");
        btnHighscores = new Button("Highscores");
        btnHighscores.getStyleClass().addAll("startbtn");
        welcome = new Label("Welcome to Stratego");
        btnQuit = new Button("Quit");
        btnQuit.getStyleClass().addAll("startbtn");

    }

    public Button getBtnQuit() {
        return btnQuit;
    }

    public Button getBtnStartNew() {
        return btnStartNew;
    }

    public Button getBtnPlay() {
        return btnPlay;
    }

    public Button getBtnSettings() {
        return btnSettings;
    }

    public Button getBtnRules() {
        return btnRules;
    }

    public Button getBtnHighscores() {
        return btnHighscores;
    }

    public Label getWelcome() {
        return welcome;
    }
}

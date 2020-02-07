import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;


public class MainMenuView extends GridPane {
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
        this.setAlignment(Pos.CENTER);setVgap(20);

    }

    private void initialiseNodes() {
        btnStartNew = new Button("Start new game");
        btnPlay = new Button("Continue game");
        btnSettings = new Button("Setttings");
        btnRules = new Button("Rules");
        btnHighscores = new Button("Highscores");
        welcome = new Label("Welcome to Stratego");
        btnQuit = new Button("Quit");

    }

    public Button getBtnQuit() {
        return btnQuit;
    }
}

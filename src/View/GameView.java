package View;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

public class GameView extends TilePane {
    private Label lblScore;
    private Button btnPause;

    public GameView() {
        initialiseNodes();
        layoutNodes();
    }

    private void layoutNodes() {
        getChildren().addAll(lblScore, btnPause);
        lblScore.setAlignment(Pos.TOP_LEFT);
        btnPause.setAlignment(Pos.TOP_RIGHT);
    }

    private void initialiseNodes() {
        lblScore = new Label("Score:");
        btnPause = new Button("Pause");
    }

    public Button getBtnPause() {
        return btnPause;
    }

}

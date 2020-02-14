package View;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

public class SaveView extends VBox {
    private Label lblName;
    private TextArea taName;
    private Button btnSave;

    public SaveView(){
        initialiseNodes();
        layoutNodes();
    }

    private void layoutNodes() {
        getChildren().addAll(lblName, taName,btnSave);
    }

    private void initialiseNodes() {
        lblName = new Label("What is your name:");
        taName = new TextArea();
        btnSave = new Button("Save");
    }

    public Label getLblName() {
        return lblName;
    }

    public TextArea getTaName() {
        return taName;
    }


    public Button getBtnSave() {
        return btnSave;
    }
}

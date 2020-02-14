package View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;


public class SetupView extends BorderPane {
    private GridPane gridPane = new GridPane();
    private Label lblSetup;
    private Button btnStandardConfig;
    private Button[][] buttonList = new Button[10][10];
    private List<Button> unitPickerLeft = new ArrayList<>();
    private List<Button> unitPickerRight = new ArrayList<>();
    private Button btn;

    public SetupView() {
        initialiseNodes();
        layoutNodes();
    }

    private void layoutNodes() {
        this.setAlignment(lblSetup, Pos.TOP_CENTER);
        this.setAlignment(btnStandardConfig, Pos.TOP_RIGHT);
        this.setAlignment(gridPane, Pos.CENTER);
        gridPane.setVgap(20);
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(20);
        gridPane.setVgap(20);

    }

    private void initialiseNodes() {
        lblSetup = new Label("Set up your army");
        btnStandardConfig = new Button("Use the standard army configuration");
        for (int i = 0; i < buttonList.length; i++) {
            for (int j = 0; j < buttonList[i].length; j++) {
                btn = new Button("",new Rectangle(10,10));
                gridPane.add(btn, i, j);
            }
        }
        for (int i = 0; i < 6; i++){
            unitPickerLeft.add(btn);
        }
        for (int i = 0; i < 6; i++){
            unitPickerRight.add(btn);
        }
        gridPane.getChildren();
        gridPane.setAlignment(Pos.CENTER);
    }


    public Label getLblSetup() {
        return lblSetup;
    }

    public Button getBtnStandardConfig() {
        return btnStandardConfig;
    }
}

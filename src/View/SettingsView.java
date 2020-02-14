package View;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class SettingsView extends VBox {
    private Button btnFullscreen;
    private Button btnSound;
    private Button btnback;

    public SettingsView(){
        initialiseNodes();
        layoutNodes();
    }

    private void layoutNodes() {
    }

    private void initialiseNodes() {
        btnback = new Button("Back");
        btnFullscreen = new Button("Full-screen");
        btnSound = new Button("Sound on/off");
    }

    public Button getBtnFullscreen() {
        return btnFullscreen;
    }

    public Button getBtnSound() {
        return btnSound;
    }

    public Button getBtnback() {
        return btnback;
    }
}


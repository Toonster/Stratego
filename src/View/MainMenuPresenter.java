package View;

import Main.StrategoMain;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class MainMenuPresenter {
    private StrategoMain model;
    private MainMenuView view;
    private File rulesFile = new File("D:\\Kdg\\Programmeren\\P3W1\\TestFX\\src\\sample\\Files\\rules.txt");
    private List<String> records = new ArrayList<String>();

    public MainMenuPresenter(StrategoMain model, MainMenuView view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
        updateView();
        rulesFile = new File("D:\\Kdg\\Programmeren\\P3W1\\TestFX\\src\\sample\\Files\\rules.txt");
    }

    private void updateView() {
    }

    private void addEventHandlers() {
        view.getBtnQuit().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
        view.getBtnQuit().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to quit?", ButtonType.YES, ButtonType.NO);
                alert.showAndWait();
                if (alert.getResult() == ButtonType.YES) {
                    System.exit(0);
                }
                else{
                    alert.close();
                }
            }
        });
        view.getBtnRules().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    BufferedReader reader = new BufferedReader(new FileReader(rulesFile));
                }
                catch (FileNotFoundException e){
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                }
            }
        });

        view.getBtnStartNew().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                SetupView setupView = new SetupView();
                SetupPresenter setupPresenter = new SetupPresenter(model, setupView);
                view.getScene().setRoot(setupView);
            }
        });


    }
}

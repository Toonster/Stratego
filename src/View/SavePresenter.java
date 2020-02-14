package View;

import Main.StrategoMain;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class SavePresenter {
    private StrategoMain model;
    private SaveView view;

    public SavePresenter(StrategoMain model, SaveView view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
        updateView();
    }

    private void updateView() {
    }

    private void addEventHandlers() {
        view.getBtnSave().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

            }
        });
    }
}

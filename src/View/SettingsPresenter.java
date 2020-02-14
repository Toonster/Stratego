package View;


import Main.StrategoMain;

public class SettingsPresenter {
    private StrategoMain model;
    private SettingsView view;


     SettingsPresenter(StrategoMain model, SettingsView view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
        updateView();
    }

    private void updateView() {
    }

    private void addEventHandlers() {
    }
}

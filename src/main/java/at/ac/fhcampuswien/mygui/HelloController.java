package at.ac.fhcampuswien.mygui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onSwitchSceneClick() {
        SceneManager.getInstance().switchScene("other-view.fxml", "hello second screen");
    }
}
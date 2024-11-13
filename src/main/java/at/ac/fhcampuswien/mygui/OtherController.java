package at.ac.fhcampuswien.mygui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class OtherController implements ControllerWithData<String> {
    @FXML
    private Label otherLabel;

    @Override
    public void setData(String data) {
        otherLabel.setText("passed data: " + data);
    }

    @FXML
    protected void onSwitchSceneClick(){
        SceneManager.getInstance().switchScene("hello-view.fxml");
    }
}
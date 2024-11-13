package at.ac.fhcampuswien.mygui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        SceneManager.getInstance().setPrimaryStage(stage, "Hello!");
        SceneManager.getInstance().switchScene("hello-view.fxml");
    }

    public static void main(String[] args) {
        launch();
    }
}
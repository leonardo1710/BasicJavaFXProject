package at.ac.fhcampuswien.mygui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class SceneManager {
    private static SceneManager instance;
    private Stage primaryStage;

    // Private constructor for Singleton pattern
    private SceneManager() {}

    public static SceneManager getInstance() {
        if (instance == null) {
            instance = new SceneManager();
        }
        return instance;
    }

    public void setPrimaryStage(Stage stage, String title) {
        stage.setTitle(title);
        this.primaryStage = stage;
    }

    public <T> void switchScene(String fxmlFile, T data) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();
            Scene scene = new Scene(root, 320, 240);

            Object controller = loader.getController();
            if (controller instanceof ControllerWithData<?>) {
                ControllerWithData<T> controllerWithData = (ControllerWithData<T>) controller;
                controllerWithData.setData(data);
            }

            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void switchScene(String fxmlFile) {
        switchScene(fxmlFile, null);
    }

}

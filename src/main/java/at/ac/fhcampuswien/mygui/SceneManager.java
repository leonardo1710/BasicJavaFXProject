package at.ac.fhcampuswien.mygui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SceneManager {
    private static SceneManager instance;
    private Stage primaryStage;
    private Map<String, Scene> sceneCache = new HashMap<>();


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
            Scene scene = sceneCache.get(fxmlFile);

            if(scene == null) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
                Parent root = loader.load();
                scene = new Scene(root, 320, 240);

                // Store the scene in the cache for future use
                sceneCache.put(fxmlFile, scene);

                // Store the controller as user data in the Scene object
                scene.setUserData(loader.getController());

                Object controller = loader.getController();
                if (controller instanceof ControllerWithData<?>) {
                    ControllerWithData<T> controllerWithData = (ControllerWithData<T>) controller;
                    controllerWithData.setData(data);
                }
            } else {
                System.out.println("reusing controller");
                Object controller = scene.getUserData();
                if (controller instanceof ControllerWithData<?>) {
                    ControllerWithData<T> baseController = (ControllerWithData<T>) controller;
                    baseController.setData(data);
                }
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

    public void clearSceneCache() {
        sceneCache.clear();
    }
}

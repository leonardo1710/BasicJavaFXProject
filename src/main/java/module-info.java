module at.ac.fhcampuswien.mygui {
    requires javafx.controls;
    requires javafx.fxml;


    opens at.ac.fhcampuswien.mygui to javafx.fxml;
    exports at.ac.fhcampuswien.mygui;
}
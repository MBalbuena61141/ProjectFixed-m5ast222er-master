package View;

import Model.DatabaseConnection;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;

public class Main extends Application {

    public static DatabaseConnection database;
    public static Stage stage;
    public static int userLogged;

    @Override
    public void start(Stage startStage) {

        stage = startStage;
        database = new DatabaseConnection("DatabaseProject.db");
        userLogged = 1;
        HomePage.makeHomePage();

    }
}
package View;
import Controller.LogInController;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.beans.EventHandler;


public class LogIn {

    public static void makeLogIn(Stage startStage) {

        //Scene snece = new Scene;

        Stage logInStage= new Stage();
        logInStage.initModality(Modality.WINDOW_MODAL);
        logInStage.initOwner(startStage);
        logInStage.setTitle("LOG IN");

        BorderPane root = new BorderPane();

        Scene logInScene = new Scene(root,300,150);
        logInStage.setScene(logInScene);

        logInStage.show();

        GridPane grid = new GridPane();
        grid.setVgap(5);
        grid.setHgap(5);

        root.setCenter(grid);

//Defining the Name text field
        final TextField userName = new TextField();
        userName.setPromptText("Enter your userName");
        GridPane.setConstraints(userName, 0, 0);
        grid.getChildren().add(userName);

//Defining the password field
        final PasswordField userPass = new PasswordField();
        GridPane.setConstraints(userPass, 0, 1);
        grid.getChildren().add(userPass);

        // Button to sign in and close
        Button SignUpButton = new Button("Log In");
        SignUpButton.setTranslateX(100);
        SignUpButton.setTranslateY(100);
        SignUpButton.setOnAction(EventHandler -> LogInController.attemptLogin(userName.getText(), userPass.getText(), logInStage));
        grid.getChildren().add(SignUpButton);


    }
}



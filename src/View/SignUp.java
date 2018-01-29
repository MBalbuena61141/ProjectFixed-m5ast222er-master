package View;
import Controller.SignUpController;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import static View.Main.database;

public class SignUp {

    public static void makeSignUp(Stage signUpStage){

        Stage signUpS = new Stage();
        signUpS.initModality(Modality.WINDOW_MODAL);
        signUpS.initOwner(signUpStage);
        signUpS.setTitle("SIGN UP");

        BorderPane root = new BorderPane();

        Scene signUpScene = new Scene(root,300,150);
        signUpS.setResizable(false);

        signUpS.setScene(signUpScene);

        GridPane grid = new GridPane();
        grid.setVgap(5);
        grid.setVgap(5);

        root.setCenter(grid);
        root.setCenter(grid);

//Defining the Name text field
        final TextField userName = new TextField();
        userName.setPromptText("Enter your new User Name");
        GridPane.setConstraints(userName, 0, 0);
        grid.getChildren().add(userName);

//Defining the Comment text field
        final TextField password = new TextField();
        password.setPromptText("Enter your new password");
        GridPane.setConstraints(password, 0, 2);
        grid.getChildren().add(password);


        // Button to sign in and close
        Button SignUpButton = new Button("LogingIn");
        SignUpButton.setTranslateX(100);
        SignUpButton.setTranslateY(100);
        SignUpButton.setOnAction(EventHandler -> SignUpController.processSignUp(userName.getText(), password.getText(), signUpS));
        grid.getChildren().add(SignUpButton);


        signUpS.show();



    }
}






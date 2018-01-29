package Controller;

import Model.UserInfo;
import Model.UserInfoService;
import View.Main;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class SignUpController {

    public static void processSignUp(String username, String password, Stage stage) {

        UserInfo newUser = new UserInfo(0, username, password);
        UserInfoService.save(newUser, Main.database);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("New user successfully created :)");

        alert.showAndWait();

        stage.close();

    }

}

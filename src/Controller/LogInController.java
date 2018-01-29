package Controller;


import Model.UserInfo;
import Model.UserInfoService;
import View.Main;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.util.ArrayList;

public class LogInController {

        public static void attemptLogin(String username, String password, Stage stage) {

            ArrayList<UserInfo> allUsers = new ArrayList<>();

            UserInfoService.selectAll(allUsers, Main.database);

            for (UserInfo u: allUsers) {

                if (u.getUserName().equals(username)) {

                    if (u.getUserPassword().equals(password)) {

                        stage.close();
                        return;

                    } else {

                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Login Error");
                        alert.setHeaderText("Wrong Password");
                        alert.setContentText("Ooops, that's not your password!");

                        alert.showAndWait();
                        return;

                    }

                }

            }

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Error");
            alert.setHeaderText("Wrong Username");
            alert.setContentText("Nope, can't find you!");

            alert.showAndWait();

        }



    }

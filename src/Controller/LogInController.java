package Controller;


import Model.UserInfo;
import Model.UserInfoService;
import View.Main;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.util.ArrayList;


public class LogInController {

    private static String thisuserName;
    private static String thispassWord;



    public static void attemptLogin(String username, String password, Stage stage) {

        ArrayList<UserInfo> allUsers = new ArrayList<>();


            UserInfoService.selectAll(allUsers, Main.database);

            for (UserInfo thisUser: allUsers) {

                if (thisUser.getUserName().equals(username)) {
                    thisuserName = username;

                    if (thisUser.getUserPassword().equals(password)) {
                        thispassWord = password;
                        Alert success = new Alert(Alert.AlertType.CONFIRMATION);
                        success.setTitle ("Logged in successful");
                        success.setHeaderText("Logged in successful");
                        success.close();
                        stage.close();
                        Main.userLogged = thisUser.getUserID();
                        Main.userNameLogged = thisUser.getUserName();
                        System.out.println("The userLogged in is " + Main.userLogged);

                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Information Dialog");
                        alert.setHeaderText(null);
                        alert.setContentText("You have logged In");

                        alert.showAndWait();

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

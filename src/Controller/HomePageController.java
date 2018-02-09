package Controller;

import Model.Movie;
import Model.MovieService;
import View.Main;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class HomePageController {


    public static void loadLogIn() {
        View.LogIn.makeLogIn(Main.stage);
    }
    public static  void loadSignUp() {
       View.SignUp.makeSignUp(Main.stage);
    }

    public  static void loadMoviePage(Movie movie) {
        View.MoviePage.makeMoviePage((movie));
    }

    public  static void loadHomePage () {
        View.HomePage.makeHomePage();
    }

    public  static  void loadUserWatchList(String searchTerm) {
        if(Main.userLogged != 0 || searchTerm !="") {
            View.UserWatchList.makeUserWatchList(searchTerm);
            System.out.println(Main.userLogged);
        }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Log In required");
                alert.setContentText("You need to log in before using your Watch List");
                alert.showAndWait();
            }
        }
    }




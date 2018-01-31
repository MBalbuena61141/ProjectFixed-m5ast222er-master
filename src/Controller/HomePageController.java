package Controller;

import Model.Movie;
import Model.MovieService;
import View.Main;
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

    public static void loadSearchPage (){
        View.SearchPage.makeSearchPage();
    }

    public  static void loadHomePage () {
        View.HomePage.makeHomePage();
    }

    public  static  void loadUserWatchList() {
        View.UserWatchList.makeUserWatchList();
    }





}

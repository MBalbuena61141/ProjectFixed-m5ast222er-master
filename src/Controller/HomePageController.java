package Controller;

import Model.MovieService;
import View.Main;

public class HomePageController {


    public static void loadLogIn() {

        View.LogIn.makeLogIn(Main.stage);
    }

    public static  void loadSignUp() {

       View.SignUp.makeSignUp(Main.stage);

    }

    public  static void loadMoviePage(int movieID) {


        View.MoviePage.makeMoviePage((movieID));


    }



}

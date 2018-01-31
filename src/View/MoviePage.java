package View;
import Controller.HomePageController;
import Model.Movie;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;

public class MoviePage {



    public static void makeMoviePage(Movie movie) {

        //System.out.println("the page that has loaded is for the movie" + movieID);
        BorderPane root = new BorderPane();
        Scene movieScene = new Scene(root, 1024, 758);



        Main.stage.setScene(movieScene);

        movieScene.getStylesheets().add("CSS.css");

        HBox topPane = new HBox(20);

        root.setTop(topPane);

        topPane.setAlignment(Pos.TOP_LEFT);
        topPane.getStyleClass().add("logoPane");
        BorderPane.setAlignment(topPane, Pos.TOP_CENTER);


        Button logo = new Button("Logo");
        logo.getStyleClass().add("Logo");
        logo.setOnAction((ae) -> HomePageController.loadHomePage());
        topPane.getChildren().add(logo);

        Button search = new Button("Search");
        search.setPrefSize(200, 25);
        search.getStyleClass().add("topButtons");
        topPane.getChildren().add(search);


        Button watchList = new Button("Your Watch List");
        watchList.setPrefSize(150, 25);
        watchList.getStyleClass().add("topButtons");
        watchList.setOnAction((ae)->HomePageController.loadUserWatchList());
        topPane.getChildren().add(watchList);

        Button logIn = new Button("LogIn");
        logIn.setPrefSize(80, 25);
        logIn.getStyleClass().add("topButtons");
        logIn.setOnAction((ae) -> HomePageController.loadSignUp());
        topPane.getChildren().add(logIn);

        Button signUp = new Button("SignUp");
        signUp.setPrefSize(90, 25);
        // signUp.getStyleClass().add("topButtons");
        signUp.setOnAction((ae) -> HomePageController.loadLogIn());
        topPane.getChildren().add(signUp);

        root.setTop(topPane);

        VBox leftPane = new VBox();
        leftPane.setPrefSize(195,1024);
        root.setLeft(leftPane);

        VBox rightPane = new VBox();
        rightPane.setPrefSize(195,850);
        rightPane.getStyleClass().add("pane");
        root.setRight(rightPane);

        VBox trailerMiddle = new VBox();
        trailerMiddle.setPrefSize(840, 390);
        trailerMiddle.getStyleClass().add("web-view");
        trailerMiddle.setPrefSize(400,250);

        WebView trailer = new WebView();
        trailer.setPrefSize(200, 390);

         // Here the movieId that bas been passed from the Homepage is being checked with a number.
            trailer.getEngine().load(movie.getMovieUrl());// The URL is then linked (manually)


        trailerMiddle.getChildren().add(trailer);
        root.setCenter(trailerMiddle);











    }


}





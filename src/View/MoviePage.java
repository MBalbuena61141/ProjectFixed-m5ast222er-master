package View;
import Controller.HomePageController;
import Model.Movie;
import Model.MovieService;
import Model.YoutubeUrl;
import Model.YoutubeUrlService;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ArrayList;

public class MoviePage {





    public static void makeMoviePage(int movieID) {

        System.out.println("the page that has loaded is for the movie" + movieID);
        BorderPane root = new BorderPane();
        Scene movieScene = new Scene(root, 1024, 768);



        Main.stage.setScene(movieScene);

        movieScene.getStylesheets().add("CSS.css");

        HBox topPane = new HBox(20);

        root.setTop(topPane);

        topPane.setAlignment(Pos.TOP_LEFT);
        topPane.getStyleClass().add("logoPane");
        BorderPane.setAlignment(topPane, Pos.TOP_CENTER);


        Button logo = new Button("Logo");
        logo.getStyleClass().add("Logo");
        topPane.getChildren().add(logo);

        Button search = new Button("Search");
        search.setPrefSize(200, 25);
        search.getStyleClass().add("topButtons");
        topPane.getChildren().add(search);


        Button watchList = new Button("Your Watch List");
        watchList.setPrefSize(150, 25);
        watchList.getStyleClass().add("topButtons");
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



        WebView trailer = new WebView();

        if (movieID==1) { // Here the movieId that bas been passed from the Homepage is being checked with a number.
            trailer.getEngine().load("https://www.youtube.com/embed/ayTnvVpj9t4");// The URL is then linked (manually)
            trailer.setPrefSize(640, 390);

        }if (movieID == 2) {
            trailer.getEngine().load("https://www.youtube.com/embed/d2S8D_SCAJY");
            trailer.setPrefSize(640, 390);

        }else if (movieID == 3){
            trailer.getEngine().load("https://www.youtube.com/embed/0pdqf4P9MB8");
            trailer.setPrefSize(640,390);
        }



        root.setCenter(trailer);



        // LEEEEEEEFT FOR PICTUREEEEEE//
        VBox leftPicture = new VBox(20);
        leftPicture.setPrefSize(200, 50);
        leftPicture.getStyleClass().add("leftPicture");

        root.setLeft(leftPicture);

        // MIDDLEEEE FOR VIDEO//

        HBox middlePane = new HBox(20);
        middlePane.setPrefSize(1024, 100);
        middlePane.getStyleClass().add("moviePane");



        /*Movie movie = MovieService.selectById(movieID, Main.database);
        System.out.println((movie.toString()));
        String movieFileName = movie.getfileName();
        String movieTitle = movie.getmovieTitle();

        URL mediaURL = MovieService.class.getResource("../Videos/" + movieFileName);
        //to print in console what is in mediaURL:
        System.out.println(mediaURL.toString());
        Media trailerMedia = new Media(mediaURL.toString());
        MediaPlayer trailerPlayer = new MediaPlayer(trailerMedia);
        MediaView trailerVideo = new MediaView(trailerPlayer);

        Button random = new Button(movieTitle + "hi");
        middlePane.getChildren().add(random)

        trailerVideo.setFitWidth(341);
        trailerVideo.setFitHeight(200);
        middlePane.getChildren().add(trailerVideo);*/









    }


}









// STARTING MIDDLE SECTION <----------------->

       /* private static  VBox makeMiddlePane (int movieID){

            VBox trailerPane = new VBox(20);
            trailerPane.setPrefSize(800, 384);
            Movie thisMovie = MovieService.selectById(movieID,database);

            Media trailerMedia = new Media(Main.class.getResource("../Videos/" + thisMovie.getfileName()).toString());
            MediaPlayer trailerPlayer = new MediaPlayer(trailerMedia);
            MediaView trailerVideo = new MediaView(trailerPlayer);
            trailerVideo.setFitWidth(341);
            trailerVideo.setFitHeight(200);
            pane.getChildren().add(trailerVideo);

            Button trailerButton = new Button(thisMovie.getmovieTitle());
            trailerButton.setPrefSize(100,150);
            trailerButton.setOnAction((ae) -> trailerPlayer.play());
            trailerButton.setAlignment(Pos.CENTER);*/


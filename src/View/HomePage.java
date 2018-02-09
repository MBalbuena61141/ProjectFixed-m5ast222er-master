package View;

import Controller.HomePageController;
import Model.Director;
import Model.MovieDirectorService;
import Model.Movie;
import Model.MovieService;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javafx.scene.web.WebView;

import java.util.ArrayList;

import static View.Main.database;
// comment
public class HomePage {


    public static void makeHomePage() {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 1024, 768);

        Main.stage.setTitle("Application");
        Main.stage.setScene(scene);
        Main.stage.show();

        root.setPadding(new Insets(10));

        scene.getStylesheets().add("CSS.css");

        HBox topPane = new HBox(20);

        topPane.setAlignment(Pos.TOP_LEFT);
        topPane.getStyleClass().add("logoPane");
        BorderPane.setAlignment(topPane, Pos.TOP_CENTER);

        Button logo = new Button("Logo");
        logo.getStyleClass().add("Logo");
        topPane.getChildren().add(logo);


        TextField searchMovie = new TextField();
        searchMovie.setPrefSize(200, 25);
        //searchMovie.getStyleClass().add("topButtons");
        topPane.getChildren().add(searchMovie);

        Button search = new Button("Search");
        search.setOnAction(EventHandler -> HomePageController.loadUserWatchList(searchMovie.getText()));
        topPane.getChildren().add(search);

        Button watchList = new Button("Your Watch List");
        watchList.setPrefSize(150, 25);watchList.getStyleClass().add("topButtons");
        watchList.setOnAction((ae) -> HomePageController.loadUserWatchList(""));

        topPane.getChildren().add(watchList);

        Button logIn = new Button("LogIn");
        logIn.setPrefSize(80, 25);
        logIn.getStyleClass().add("topButtons");
        logIn.setOnAction((ae) -> HomePageController.loadLogIn());
        topPane.getChildren().add(logIn);
        Button signUp = new Button("SignUp");
        signUp.setPrefSize(90, 25);
        // signUp.getStyleClass().add("topButtons");
        signUp.setOnAction((ae) -> HomePageController.loadSignUp());
        topPane.getChildren().add(signUp);

        root.setTop(topPane);       // <<<<<<< TOP
            // CENTRE SECTION STARTS.

        root.setLeft(makeTrailerPane(1));
        root.setCenter(makeTrailerPane(2));
        root.setRight(makeTrailerPane(3));
        }

        public static VBox makeTrailerPane(int movieID) {

            VBox pane = new VBox(20);
            pane.setPrefSize(341, 153);

            Movie thisMovie = MovieService.selectById(movieID,database);
            ArrayList<Director> directors = MovieDirectorService.selectDirector(movieID,database);

            HBox trailerContainer = new HBox();
            trailerContainer.setPrefSize(390,200);

            WebView trailer = new WebView();
            trailer.setPrefSize(390, 200);
            trailer.getEngine().load(thisMovie.getMovieUrl());
            trailerContainer.getChildren().add(trailer);

            pane.getChildren().add(trailerContainer);

            Button movieButton = new Button(thisMovie.getMovieTitle());
            movieButton.setOnAction((ae)->HomePageController.loadMoviePage(thisMovie));

            movieButton.setPrefSize(150,50);
            pane.getChildren().add(movieButton);
            movieButton.setAlignment(Pos.CENTER);

            Label someText1 = new Label("Plot:");
            pane.getChildren().add(someText1);

            Label someText3 = new Label(thisMovie.getMoviePlot());
            someText3.setWrapText(true);
            pane.getChildren().add(someText3);



            String directorNames = new String();

            for (int i = 0; i< directors.size(); i++){
                directorNames += " - " + directors.get(i).getDirectorName();
            }

            Label director = new Label("Director:" );
            pane.getChildren().add(director);

            Label theDirectors = new Label(directorNames);
            pane.getChildren().add(theDirectors);

            return pane;



        }

    }
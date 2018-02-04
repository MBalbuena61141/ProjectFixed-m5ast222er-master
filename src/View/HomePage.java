package View;

import Controller.HomePageController;
import Model.Movie;
import Model.MovieService;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javafx.scene.web.WebView;

import static View.Main.database;
// comment
public class HomePage {


    public static void makeHomePage() {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 1024, 768);

        Main.stage.setTitle("Application");
        Main.stage.setScene(scene);
        Main.stage.show();

        scene.getStylesheets().add("CSS.css");


        //Top Buttons (Logo, search, watchlist and login/sign up)//

        HBox topPane = new HBox(20);

        topPane.setAlignment(Pos.TOP_LEFT);
        topPane.getStyleClass().add("logoPane");
        BorderPane.setAlignment(topPane, Pos.TOP_CENTER);


        Button logo = new Button("Logo");
        logo.getStyleClass().add("Logo");
        topPane.getChildren().add(logo);

        Button search = new Button("Search");
        search.setPrefSize(200, 25);
        search.setOnAction((ae)->HomePageController.loadSearchPage());
        search.getStyleClass().add("topButtons");
        topPane.getChildren().add(search);


        Button watchList = new Button("Your Watch List");
        watchList.setPrefSize(150, 25);watchList.getStyleClass().add("topButtons");
        watchList.setOnAction((ae)->HomePageController.loadUserWatchList());

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


            // UserInfo userName = UserInfoService.selectAll();

        Label userLogged = new Label("Hello");
        userLogged.setPrefSize(90,25);
        userLogged.getStyleClass().add("topButtons");
        topPane.getChildren().add(userLogged);


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

            HBox trailerContainer = new HBox();
            trailerContainer.setPrefSize(390,200);

            WebView trailer = new WebView();
            trailer.setPrefSize(390, 200);
            trailer.getEngine().load(thisMovie.getMovieUrl());
            trailerContainer.getChildren().add(trailer);

            pane.getChildren().add(trailerContainer);


            Button trailerButton = new Button(thisMovie.getMovieTitle());
            Button movieButton = new Button(thisMovie.getMovieTitle());
            movieButton.setOnAction((ae)->HomePageController.loadMoviePage(thisMovie));


            trailerButton.setPrefSize(100, 50);
            pane.getChildren().add(trailerButton);
            trailerButton.setAlignment(Pos.CENTER);

            movieButton.setPrefSize(75,50);
            pane.getChildren().add(movieButton);
            movieButton.setAlignment(Pos.CENTER);

            Label someText1 = new Label("Hello1");
            pane.getChildren().add(someText1);

            Label someText2 = new Label("Hello2");
            pane.getChildren().add(someText2);

            Label someText3 = new Label("Hello3");
            pane.getChildren().add(someText3);



            return pane;



        }

    }
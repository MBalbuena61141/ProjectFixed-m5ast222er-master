package View;
import Controller.HomePageController;
import Model.*;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static View.Main.database;


public class MoviePage {


    public static void makeMoviePage(Movie movie) {

        //System.out.println("the page that has loaded is for the movie" + movieID);
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10));

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

        TextField searchMovie = new TextField();
        searchMovie.setPrefSize(200, 25);
        //searchMovie.getStyleClass().add("topButtons");
        topPane.getChildren().add(searchMovie);

        Button search = new Button("Search");
        search.setOnAction(EventHandler -> HomePageController.loadUserWatchList(searchMovie.getText()));
        topPane.getChildren().add(search);

        Button watchList = new Button("Your Watch List");
        watchList.setPrefSize(150, 25);
        watchList.getStyleClass().add("topButtons");
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

        String userName = new String();

        userName = Main.userNameLogged;
        Label userLogged = new Label(userName);
        userLogged.setPrefSize(90, 25);
        userLogged.getStyleClass().add("topButtons");
        topPane.getChildren().add(userLogged);

        root.setTop(topPane);

        //LEEEEEFT PANEEE
        VBox leftPane = new VBox();
        leftPane.setPrefSize(195, 500);
        leftPane.setPadding(new Insets(10));


        ImageView imageView = new ImageView();
        Image img = new Image("Images/" + movie.getMovieImage());
        imageView.setImage(img);
        imageView.setFitHeight(280);
        imageView.setFitWidth(200);
        leftPane.getChildren().add(imageView);


            Button addtoWatchList = new Button("Add to your WatchList");
            addtoWatchList.setPrefSize(150, 50);

        if (Main.userLogged == 0 || Main.userLogged >=1){
            addtoWatchList.setOnAction(ae -> UserWatchListService.saveMovie(movie, database));
            leftPane.getChildren().add(addtoWatchList);
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Log In required");
            alert.setContentText("You need to log in before using your add the movie");
            alert.showAndWait();
        }

        root.setLeft(leftPane);


        //MIDDLE PANEE


        VBox centrePane = new VBox(10);
        centrePane.setPadding(new Insets(10));
        centrePane.setPrefSize(840, 700);
        centrePane.getStyleClass().add("web-view");
        centrePane.setPrefSize(400, 250);

        //VIDEO ADDED
        WebView trailer = new WebView();
        trailer.setPrefSize(200, 300);
        trailer.getEngine().load(movie.getMovieUrl());
        centrePane.getChildren().add(trailer);

        //////

        Label title = new Label("Title: "+ movie.getMovieTitle());
        title.setWrapText(true);
        centrePane.getChildren().add(title);

        Label plot = new Label("Plot:");
        plot.setWrapText(true);
        centrePane.getChildren().add(plot);

        Label thisPlot = new Label(movie.getMoviePlot());
        thisPlot.setWrapText(true);
        centrePane.getChildren().add(thisPlot);


        int thisMovieID = movie.getMovieID();
        ArrayList<Actor> movieActor = MovieActorsService.selectActor(thisMovieID, database);

        String actorNames = new String();

        Label castt = new Label( "The cast:");
        centrePane.getChildren().add(castt);

        for (int i =0; i < movieActor.size(); i++) {

            actorNames = movieActor.get(i).getActorName();

            Label cast = new Label( actorNames);
            centrePane.getChildren().add(cast);
        }

        ArrayList<Producers> movieProducer = MovieProducersService.selectProducer(thisMovieID, database);

        Label producer = new Label("Producers:");
        producer.setWrapText(true);
        centrePane.getChildren().add(producer);


        String producerName = new String();

        for (int i =0; i < movieProducer.size(); i++) {

            producerName = movieProducer.get(i).getProducerName();

            Label moviePro = new Label(producerName);
            moviePro.setWrapText(true);
            centrePane.getChildren().add(moviePro);

        }

        ArrayList<Genre> movieGenre = GenreService.selectGenre(thisMovieID, database);
        Label genre = new Label("Genre:");
        genre.setWrapText(true);
        centrePane.getChildren().add(genre);

        String thisGenre = new String();

        for (int i =0; i < movieGenre.size(); i++) {

            thisGenre = movieGenre.get(i).getGenreTitle();

            Label moviegen = new Label(thisGenre);
            moviegen.setWrapText(true);
            centrePane.getChildren().add(moviegen);

        }


        root.setCenter(centrePane);

    }
}










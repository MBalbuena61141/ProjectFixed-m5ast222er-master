package View;
import Controller.HomePageController;
import Model.Movie;
import Model.UserWatchListService;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.VerticalDirection;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;

import java.util.ArrayList;


@SuppressWarnings("Duplicates")
public class UserWatchList {

    public static void makeUserWatchList(String searchTerm) {
        BorderPane root = new BorderPane();



        Scene scene = new Scene(root, 1024, 768);
        root.setPadding(new Insets(10));



        Main.stage.setScene(scene);

        Main.stage.setResizable(true);


        scene.getStylesheets().add("CSS.css");


        HBox topPane = new HBox(20);

        topPane.setAlignment(Pos.TOP_LEFT);
        topPane.getStyleClass().add("logoPane");
        BorderPane.setAlignment(topPane, Pos.TOP_CENTER);


        Button logo = new Button("Logo");
        logo.getStyleClass().add("Logo");
        logo.setOnAction((ae)->HomePageController.loadHomePage());
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


        // UserInfo userName = UserInfoService.selectAll();

        String userName = new String();

        userName = Main.userNameLogged;
        Label userLogged = new Label(userName);
        userLogged.setPrefSize(90, 25);
        userLogged.getStyleClass().add("topButtons");
        topPane.getChildren().add(userLogged);


        root.setTop(topPane);


        ArrayList<Movie> userMovies = new ArrayList<>();
        if(searchTerm != ""){
            UserWatchListService.selectMovieBySearchTerm(searchTerm ,userMovies, Main.database);
        }
        else {
            UserWatchListService.selectMoviesByUserID(userMovies, Main.database);
        }

        VBox leftPane = new VBox();
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setFitToWidth(true);
        leftPane.getChildren().add(scrollPane);

        scrollPane.setContent(leftPane);
/*
        TilePane tilePane = new TilePane();
        tilePane.prefWidthProperty().bind(root.widthProperty());
        tilePane.prefHeightProperty().bind(root.heightProperty());
        tilePane.setHgap(10);
        tilePane.setVgap(10);
        tilePane.setPadding(new Insets(20));



        for (int i = 1; i <= 256; i++) {
            Button exampleButton = new Button(Integer.toString(i));
            exampleButton.setPrefSize(100, 100);
            tilePane.getChildren().add(exampleButton);
        }
        */
        leftPane.setPrefWidth(700);


        //root.getChildren().add(scrollPane);

        int panelTop = 40;
        int height;

        for (int i = 0; i < userMovies.size(); i++) {



            System.out.println("Displaying movie " + userMovies.get(i).getMovieTitle());

            HBox imagePane = new HBox(15);
            imagePane.setPrefSize(800, 150);
            imagePane.setPadding(new Insets(15));
            root.getChildren().add(imagePane);

            imagePane.setTranslateY(panelTop);
            //panelTop += panelHeight;
            ImageView imageView = new ImageView();
            System.out.println("Trying to display " + "Images/" + userMovies.get(i).getMovieImage());

            Image img = new Image("Images/" + userMovies.get(i).getMovieImage());
            imageView.setImage(img);
            imageView.setFitHeight(280);
            imageView.setFitWidth(200);
            imagePane.getChildren().add(imageView);


            VBox info = new VBox(2);
            info.setPrefHeight(500);

            imagePane.getChildren().add(info);

            Button movieWatchButton = new Button("Click here to see movie");
            movieWatchButton.setPrefSize(200, 50);
            Movie thisMovie = userMovies.get(i);
            movieWatchButton.setOnAction((ae)->HomePageController.loadMoviePage(thisMovie));
            info.getChildren().add(movieWatchButton);

            Label movieTitle = new Label("Title: " + userMovies.get(i).getMovieTitle());
            movieTitle.setMaxWidth(500);
            movieTitle.setPrefHeight(100);
            info.getChildren().add(movieTitle);

            Label moviePlot = new Label("Director: " + userMovies.get(i).getMoviePlot());
            moviePlot.setWrapText(true);
            moviePlot.setMaxWidth(500);
            moviePlot.setPrefHeight(50);
            info.getChildren().add(moviePlot);

            leftPane.getChildren().add(imagePane);
        }
        root.setLeft(scrollPane);

        //


    }

}




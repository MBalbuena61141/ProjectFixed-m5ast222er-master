package View;
import Controller.HomePageController;
import Model.Movie;
import Model.UserWatchListService;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;

import java.util.ArrayList;


@SuppressWarnings("Duplicates")
public class UserWatchList {

    public static void makeUserWatchList() {
        BorderPane root = new BorderPane();

        Scene scene = new Scene(root, 1024, 768);

        Main.stage.setScene(scene);


        scene.getStylesheets().add("CSS.css");


        HBox topPane = new HBox(20);

        topPane.setAlignment(Pos.TOP_LEFT);
        topPane.getStyleClass().add("logoPane");
        BorderPane.setAlignment(topPane, Pos.TOP_CENTER);


        Button logo = new Button("Logo");
        logo.getStyleClass().add("Logo");
        logo.setOnAction((ae)->HomePageController.loadHomePage());
        topPane.getChildren().add(logo);

        Button search = new Button("Search");
        search.setPrefSize(200, 25);
        search.setOnAction((ae) -> HomePageController.loadSearchPage());
        search.getStyleClass().add("topButtons");
        topPane.getChildren().add(search);


        Button watchList = new Button("Your Watch List");
        watchList.setPrefSize(150, 25);
        watchList.getStyleClass().add("topButtons");
        watchList.setOnAction((ae) -> HomePageController.loadUserWatchList());

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

        Label userLogged = new Label("hi");
        userLogged.setPrefSize(90, 25);
        userLogged.getStyleClass().add("topButtons");
        topPane.getChildren().add(userLogged);


        root.setTop(topPane);


        ArrayList<Movie> userMovies = new ArrayList<>();
        UserWatchListService.selectMoviesByUserID(userMovies, Main.database);

        VBox leftPane = new VBox();
        leftPane.setPrefWidth(700);

        int panelHeight = 300;
        int panelTop = 40;

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
            root.setLeft(leftPane);
    }

}




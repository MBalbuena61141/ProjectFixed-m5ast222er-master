package View;
import Controller.HomePageController;
import Model.Movie;
import Model.UserWatchListService;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
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
        topPane.getChildren().add(logo);

        Button search = new Button("Search");
        search.setPrefSize(200, 25);
        search.setOnAction((ae)->HomePageController.loadSearchPage());
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
        logIn.setOnAction((ae) -> HomePageController.loadLogIn());
        topPane.getChildren().add(logIn);

        Button signUp = new Button("SignUp");
        signUp.setPrefSize(90, 25);
        // signUp.getStyleClass().add("topButtons");
        signUp.setOnAction((ae) -> HomePageController.loadSignUp());
        topPane.getChildren().add(signUp);


        // UserInfo userName = UserInfoService.selectAll();

        Label userLogged = new Label("hi");
        userLogged.setPrefSize(90,25);
        userLogged.getStyleClass().add("topButtons");
        topPane.getChildren().add(userLogged);



        root.setTop(topPane);


        HBox space = new HBox(20);
        //pace.set

        ArrayList<Movie> userMovies = new ArrayList<>();
        UserWatchListService.selectMoviesByUserID(userMovies, Main.database);

        VBox leftPane = new VBox(20);
        leftPane.setPrefSize(200,600);



        for (Movie thisUserMovie: userMovies) {

            System.out.println("Displaying movie " + thisUserMovie.toString());

            ImageView imageView = new ImageView();
            System.out.println("Trying to display " + "Images/" + thisUserMovie.getMovieImage());
            Image img = new Image("Images/" + thisUserMovie.getMovieImage());
            imageView.setImage(img);
            imageView.setFitHeight(200);
            imageView.setFitWidth(150);
            leftPane.getChildren().add(imageView);

        }
        root.setLeft(leftPane);













    }


}

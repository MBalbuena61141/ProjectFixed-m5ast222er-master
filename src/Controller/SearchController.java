package Controller;

import Model.DatabaseConnection;
import Model.Movie;
import Model.MovieActorsService;
import Model.MovieService;
import View.Main;
import javafx.scene.control.Alert;

import java.sql.PreparedStatement;
import java.util.ArrayList;

public class SearchController{

    private  static  String thisMovieSearch;

    public static void searchMovie (String searchMovie, DatabaseConnection database) {

        ArrayList<Movie> allMovies = new ArrayList<>();

        MovieService.selectAll(allMovies, Main.database);

        for (Movie movie: allMovies) {

            if (movie.getMovieTitle().equals(searchMovie)){


                HomePageController.loadMoviePage((movie));


            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Search Error");
                alert.setHeaderText("Movie not found");
                alert.setContentText("We could not find this movie");
                alert.showAndWait();
                return;

            }


        }

    }


}

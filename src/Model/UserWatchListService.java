package Model;

import View.Main;
import javafx.scene.control.Alert;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static View.Main.database;
import static View.Main.userLogged;

public class UserWatchListService {

    public static void selectMoviesByUserID(ArrayList<Movie> userMovies, DatabaseConnection database) {


        PreparedStatement statement = database.newStatement("SELECT * FROM UserWatchList INNER JOIN Movie ON UserWatchlist.movieID = Movie.movieID WHERE UserWatchList.userID = ?");
        try {
            if (statement != null) {

                statement.setInt(1, Main.userLogged);

                ResultSet results = database.executeQuery(statement);


                if (results != null) {
                    while (results.next()) {
                        userMovies.add(new Movie(results.getInt("movieID"), results.getString("movieTitle"), results.getString("movieUrl"), results.getString("movieImage"), results.getString("moviePlot")));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void selectMovieBySearchTerm(String searchTerm, ArrayList<Movie> userMovies, DatabaseConnection database) {

        String query = "SELECT * FROM Movie WHERE Movie.movieTitle LIKE '%" + searchTerm + "%'";
        PreparedStatement statement = database.newStatement(query);
        //PreparedStatement statement = database.newStatement("SELECT * FROM Movie WHERE Movie.movieTitle LIKE '%?%'");
        try {
            if (statement != null) {
                //statement.setString(1, searchTerm);

                ResultSet results = database.executeQuery(statement);

                if (results != null) {
                    while (results.next()) {
                        userMovies.add(new Movie(results.getInt("movieID"), results.getString("movieTitle"), results.getString("movieUrl"), results.getString("movieImage"), results.getString("moviePlot")));
                    }
                }
            } else {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Movie not found");
                alert.setHeaderText("Movie not found");
                alert.setContentText("Sorry, we could not find the movie");
                alert.showAndWait();
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void saveMovie(Movie userMovies, DatabaseConnection database) {

        Movie thisMovie = null;
        try {
            if (thisMovie  == null) {
                PreparedStatement statement = database.newStatement("INSERT INTO UserWatchList (movieID, userID) VALUES (?,?)");
                statement.setInt(1, userMovies.getMovieID());
                statement.setInt(2, Main.userLogged);
                database.executeUpdate(statement);
            }
        } catch (SQLException resultsException) {
            System.out.println("Database saving error: " + resultsException.getMessage());
        }

    }
}





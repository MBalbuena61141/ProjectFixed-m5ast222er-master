package Model;

import View.Main;

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

}


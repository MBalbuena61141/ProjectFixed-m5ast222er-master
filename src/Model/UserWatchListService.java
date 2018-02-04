package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static View.Main.database;

public class UserWatchListService {

    public static void selectMoviesByUserID(int UserID, ArrayList<Movie> userMovies, DatabaseConnection database) {

        PreparedStatement statement = database.newStatement("SELECT * FROM UserWatchList INNER JOIN Movie ON UserWatchlist.movieID = Movie.userID WHERE userID = 1");
        try {
            if (statement != null) {

                ResultSet results = database.executeQuery(statement);

                if (results != null) {
                    while (results.next()) {
                        targetList.add(new UserWatchList(results.getInt("movieID"), results.getInt("userID")));
                    }
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select all error: " + resultsException.getMessage());
        }
    }

    // Main.userLooged

}


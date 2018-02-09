package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MovieService {

    public static Movie selectById(int id, DatabaseConnection database) {

        Movie result = null;

        PreparedStatement statement = database.newStatement("SELECT movieID, movieTitle, movieUrl, movieImage, moviePlot FROM Movie WHERE movieID = ?");

        try {
            if (statement != null) {

                statement.setInt(1, id);
                ResultSet results = database.executeQuery(statement);

                if (results != null) {
                    result = new Movie(results.getInt("movieID"), results.getString("movieTitle"), results.getString("movieUrl"), results.getString("movieImage"), results.getString("moviePlot"));
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select by id error: " + resultsException.getMessage());
        }

        return result;
    }
    public static void selectAll(List<Movie> movieList, DatabaseConnection database) {

        PreparedStatement statement = database.newStatement("SELECT movieID, movieTitle, movieImage, movieURL, moviePlot FROM Movie");
        if (statement != null) {
            ResultSet results = database.executeQuery(statement);

            if (results == null) {
                movieList.isEmpty();
                System.out.println("there was an error");
                return;
            }
        }


    }
}

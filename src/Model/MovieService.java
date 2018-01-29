package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieService {

    public static Movie selectById(int id, DatabaseConnection database) {


        Movie result = null;

        PreparedStatement statement = database.newStatement("Select movieID, fileName, movieTitle FROM Movie WHERE movieID = ?");

        try {
            if (statement != null) {

                statement.setInt(1, id);
                ResultSet results = database.executeQuery(statement);


                if (results != null) {

                    result = new Movie(results.getInt("movieID"), results.getString("movieTitle"), results.getString("fileName"));

                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select by id error: " + resultsException.getMessage());
        }

        return result;
    }


}


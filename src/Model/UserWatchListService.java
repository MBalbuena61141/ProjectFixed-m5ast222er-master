package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserWatchListService {

    public static UserWatchList selectById(int id, DatabaseConnection database) {

        UserWatchList result = null;

        PreparedStatement statement = database.newStatement("SELECT movieID, userID FROM UserWatchList");

        try {
            if (statement != null) {

                statement.setInt(1, id);
                ResultSet results = database.executeQuery(statement);

                if (results != null) {
                    result = new UserWatchList(results.getInt("userID"), results.getInt("userID"));
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select by id error: " + resultsException.getMessage());
        }

        return result;
    }
}





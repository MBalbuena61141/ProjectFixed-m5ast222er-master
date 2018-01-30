package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class YoutubeUrlService {

    public static void selectByID(int id, DatabaseConnection database) {

        YoutubeUrl result = null;

        PreparedStatement statement = database.newStatement("Select urlID ,movieUrl, movieID FROM YoutubeUrl WHERE urlID =? ");
        try {

            if (statement != null) {

                statement.setInt(1, id);
                ResultSet results = database.executeQuery(statement);

                if (results != null) {


                }


            }
        } catch (SQLException resultsException) {
            System.out.println("Database select by id error: " + resultsException.getMessage());
        }
    }

    public static void selectAll(List<YoutubeUrl> targetList, DatabaseConnection database) {

        PreparedStatement statement = database.newStatement("SELECT movieUrl, movieID, urlID FROM Table ORDER BY YoutubeUrl");

        try {
            if (statement != null) {

                ResultSet results = database.executeQuery(statement);

                if (results != null) {
                    while (results.next()) {
                        targetList.add(new YoutubeUrl(results.getString("movieUrl"), results.getInt("movieID"),results.getInt("urlID")));
                    }
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select all error: " + resultsException.getMessage());
        }
    }


}
package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class YoutubeUrlService {

    public static void selectByID(int id, DatabaseConnection database) {

        YoutubeUrl result = null;

        PreparedStatement statement = database.newStatement("Select urlID ,url, movieID FROM YoutubeUrl WHERE urlID =? ");
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
}
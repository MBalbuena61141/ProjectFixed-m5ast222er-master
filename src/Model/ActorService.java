package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ActorService {
    public static void selectAll(List<Actor> targetList, DatabaseConnection database) {

        PreparedStatement statement = database.newStatement("SELECT actorID, actorName FROM Actor");

        try {
            if (statement != null) {

                ResultSet results = database.executeQuery(statement);

                if (results != null) {
                    while (results.next()) {
                        targetList.add(new Actor(results.getInt("actorID"), results.getString("actorName")));
                    }
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select all error: " + resultsException.getMessage());
        }
    }
}
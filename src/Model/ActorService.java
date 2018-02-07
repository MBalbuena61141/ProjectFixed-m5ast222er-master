package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ActorService {

    public static ArrayList<Actor> selectActor (int id, DatabaseConnection database) {

        ArrayList<Actor> selectActor = new ArrayList<>();

        PreparedStatement statement = database.newStatement("SELECT Actor.actorID, actorName FROM Actor INNER JOIN Cast ON actor.actorID = Cast.actorID WHERE Movie.movieID = ?");

        try {
            if (statement != null) {

                ResultSet results = database.executeQuery(statement);

                if (results != null) {
                    while (results.next()) {
                        selectActor.add(new Actor(results.getInt("actorID"), results.getString("actorName")));
                    }
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select all error: " + resultsException.getMessage());
        }

        return selectActor;
    }


}
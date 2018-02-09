package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MovieActorsService {

        public static ArrayList<Actor> selectActor (int id, DatabaseConnection database) {

            ArrayList<Actor> movieActor = new ArrayList<>();

            PreparedStatement statement = database.newStatement("SELECT Actor.actorID, Actor.actorName FROM Actor INNER JOIN MovieActors ON MovieActors.actorID = Actor.actorID WHERE movieID =?");

            try {
                if (statement != null) {


                    statement.setInt(1,id);
                    ResultSet results = database.executeQuery(statement);

                    if (results != null) {
                        while (results.next()) {
                            movieActor.add(new Actor(results.getInt("actorID"), results.getString("actorName")));
                        }
                    }
                }
            } catch (SQLException resultsException) {
                System.out.println("Database select all error: " + resultsException.getMessage());
            }

            return movieActor;
        }


    }

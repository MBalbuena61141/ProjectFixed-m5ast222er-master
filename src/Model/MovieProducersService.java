package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MovieProducersService {


    public static ArrayList<Producers> selectProducer(int id, DatabaseConnection database) {

        ArrayList<Producers> movieProducer = new ArrayList<>();

        PreparedStatement statement = database.newStatement("SELECT Producer.producerID, Producer.producerName FROM Producer INNER JOIN MovieProducers ON MovieProducers.producerID= Producer.producerID WHERE movieID =?");

        try {
            if (statement != null) {


                statement.setInt(1,id);
                ResultSet results = database.executeQuery(statement);

                if (results != null) {
                    while (results.next()) {
                        movieProducer.add(new Producers(results.getInt("producerID"), results.getString("producerName")));
                    }
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select all error: " + resultsException.getMessage());
        }

        return movieProducer;
    }


}

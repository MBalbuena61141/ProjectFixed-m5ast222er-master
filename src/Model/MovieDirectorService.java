package Model;

import View.Main;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MovieDirectorService {

    public static ArrayList<Director> selectDirector (int id, DatabaseConnection database) {

        ArrayList<Director> directors = new ArrayList();

        PreparedStatement statement = database.newStatement("SELECT Director.directorID, directorName FROM Director INNER JOIN MovieDirector ON Director.directorID = MovieDirector.directorID WHERE MovieDirector.movieID = ?");
        try {
            if (statement != null) {

                statement.setInt(1, id);
                ResultSet results = database.executeQuery(statement);

                if (results != null) {
                    while (results.next()) {
                     directors.add(new Director(results.getInt("directorID"), results.getString("directorName")));
                    }
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return directors;
    }
}

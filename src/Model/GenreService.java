package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GenreService {

    public static ArrayList<Genre> selectGenre(int id, DatabaseConnection database) {

        ArrayList<Genre> movieGenre = new ArrayList<>();

        PreparedStatement statement = database.newStatement("SELECT Genre.genreID, Genre.genreName FROM Genre INNER JOIN MovieGenre ON MovieGenre.genreID= Genre.genreID WHERE movieID =?");

        try {
            if (statement != null) {


                statement.setInt(1,id);
                ResultSet results = database.executeQuery(statement);

                if (results != null) {
                    while (results.next()) {
                        movieGenre.add(new Genre(results.getInt("genreID"), results.getString("genreName")));
                    }
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select all error: " + resultsException.getMessage());
        }

        return movieGenre;
    }


}

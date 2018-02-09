package Model;

import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserInfoService {

    public static void selectAll(List<UserInfo> targetList, DatabaseConnection database) {
        PreparedStatement statement = database.newStatement("SELECT userID, userName, userPassword FROM UserInfo");
        try {
            if (statement != null) {
                ResultSet results = database.executeQuery(statement);
                if (results != null) {
                    while (results.next()) {
                        targetList.add(new UserInfo(results.getInt("userID"), results.getString("userName"), results.getString("userPassword")));
                    }
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select all error: " + resultsException.getMessage());
        }
    }

    public static void save(UserInfo itemToSave, DatabaseConnection database) {
        try {
            PreparedStatement statement = database.newStatement("INSERT INTO UserInfo (userName, userPassword) VALUES (?, ?)");
            statement.setString(1, itemToSave.getUserName());
            statement.setString(2, itemToSave.getUserPassword());
            database.executeUpdate(statement);
        } catch (SQLException resultsException) {
            System.out.println("Database saving error: " + resultsException.getMessage());
        }
    }
}

    /*public static newUser (Array<UserInfo>, DatabaseConnection database) {

         Array userInfo = new Array{}

         PreparedStatement statement = database.newStatement("SELECT * UserID FROM UserInfo")*/
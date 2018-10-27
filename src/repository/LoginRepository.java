package repository;

import util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginRepository {
    private Connection dbConnection;

    public LoginRepository() {
        dbConnection = DbUtil.getConnection();
    }

    public String getPassword(String username) {
        if (dbConnection != null) {
            try {
                PreparedStatement prepStatement = dbConnection
                        .prepareStatement("select password from User where username = ?");
                prepStatement.setString(1, username);

                ResultSet result = prepStatement.executeQuery();
                if (result != null) {
                    if (result.next()) {
                        //TODO: Debug only, remove when deploying
                        System.out.println("Correct password: " + result.getString(1));
                        return result.getString(1);
                    }
                    System.out.println("Username not found! ");
                    return "errorUsernameNotFound";
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return "errorWhatHappened";
    }

}

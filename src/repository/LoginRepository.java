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

    public boolean authenticate(String username, String password) {
        if (dbConnection != null) {
            try {
                PreparedStatement prepStatement = dbConnection
                        .prepareStatement("select password from User where username = ?");
                prepStatement.setString(1, username);

                ResultSet result = prepStatement.executeQuery();
                if (result != null) {
                    while (result.next()) {
                        if (result.getString(1).equals(password)) {
                            return true;
                        }
                        else return false;
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

}

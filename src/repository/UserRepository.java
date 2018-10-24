package repository;

import util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository implements LoginRepositoryInterface {
    private Connection dbConnection;

    public UserRepository() {
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
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

}

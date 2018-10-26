package util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DbUtil {
    private static Connection dbConnection = null;

    public static Connection getConnection() {
        if (dbConnection != null) {
            return dbConnection;
        } else {
            try {
                InputStream inputStream = DbUtil.class.getClassLoader()
                        .getResourceAsStream("db.properties");
                Properties properties = new Properties();
                if (properties != null) {
                    properties.load(inputStream);

                    String dbDriver = properties.getProperty("dbDriver");
                    String connectionUrl = properties
                            .getProperty("connectionUrl");
                    String username = properties.getProperty("username");
                    String password = properties.getProperty("password");

                    Class.forName(dbDriver).newInstance();
                    dbConnection = DriverManager.getConnection(connectionUrl,
                            username, password);
                    System.out.println("Connected to the database server successfully.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return dbConnection;
        }
    }
}

package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private DBConnection() {
    }

    private static final class ConnectionHolder {
        private static final Connection connection;

        static {
            try {
                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5434/clever?user=postgres&password=postgres");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static Connection getConnection(){

        return ConnectionHolder.connection;
    }
}

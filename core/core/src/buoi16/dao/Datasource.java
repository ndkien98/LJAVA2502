package buoi16.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class Datasource {

    private static String url = "jdbc:mysql://localhost:3306/antino";
    private static String username = "root";
    private static String password = "root";

    // cong cu quan ly danh sach connection trong connection pool
    private static HikariDataSource hikariDataSource = null;
    private static HikariDataSource init() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(url);
        config.setUsername(username);
        config.setPassword(password);
        config.setMaximumPoolSize(10); // tạo ra 10 connection pool
        return new HikariDataSource(config);
    }
    public static Connection getConnection() throws SQLException {
        if (hikariDataSource == null) {
            hikariDataSource = init();
        }
        return hikariDataSource.getConnection();
    }

    public static void closẹ(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}

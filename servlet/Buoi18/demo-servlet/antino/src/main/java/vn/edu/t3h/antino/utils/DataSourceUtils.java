package vn.edu.t3h.antino.utils;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataSourceUtils {

    private static String url = "jdbc:mysql://localhost:3306/antino";
    private static String user = "root";
    private static String password = "root";

    private static HikariDataSource hikariDataSource = null;

    private DataSourceUtils() {
    }

    private static void init(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            HikariConfig config = new HikariConfig();
            config.setJdbcUrl(url);
            config.setUsername(user);
            config.setPassword(password);
            config.setMaximumPoolSize(10);
            hikariDataSource = new HikariDataSource(config);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection(){
        if(hikariDataSource == null){
            init();
        }
        try {
            return hikariDataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(Connection con, PreparedStatement ps, ResultSet rs){
        if (con != null){
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (ps != null){
            try {
                ps.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

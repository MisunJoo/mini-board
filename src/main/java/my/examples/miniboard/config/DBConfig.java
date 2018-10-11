package my.examples.miniboard.config;

import java.sql.*;
import java.util.Properties;

public class DBConfig {
    public static Connection connect() {
        Connection conn = null;

        Properties prop = new Properties();
        try {
            prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties"));
            String jdbcDriver = prop.getProperty("jdbcDriver");
            String dbUrl = prop.getProperty("dbUrl");
            String dbUser = prop.getProperty("dbUser");
            String dbPassword = prop.getProperty("dbPassword");
            Class.forName(jdbcDriver);
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }

    public static void close(Connection conn, PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {}
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {}
        }
    }

    public static void close(Connection conn, PreparedStatement ps, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {}
        }
        close(conn, ps);
    }
}

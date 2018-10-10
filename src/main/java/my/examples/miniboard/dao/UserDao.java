package my.examples.miniboard.dao;

import my.examples.miniboard.config.DBConfig;
import my.examples.miniboard.servlet.Article;
import my.examples.miniboard.servlet.User;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private static final String dbUrl = "jdbc:mysql://localhost:3306/fcdb?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
    private static final String dbUser = "fcuser";
    private static final String dbPassword = "fc123";

    public List<User> getUserList() {
        List<User> userList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DBConfig.connect(dbUrl, dbUser, dbPassword);
            String sql = "SELECT id, user_name, password FROM user ORDER BY id";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            // rs(결과값)가 없을 때까지 반복
            // DB에서 받은 값을 각 User 객체에 set하고 list에 add한다.
            while (rs.next()) {
                User user = new User();
                user.setUserName(rs.getString(2));
                user.setPassword(rs.getString(3));

                userList.add(user);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBConfig.close(conn, ps, rs);
        }

        return userList;
    }

    public void addUser(User user){
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = DBConfig.connect(dbUrl, dbUser, dbPassword);
            String sql = "insert into user (id, user_name, password) VALUES (null, ?, ?)";
            ps = conn.prepareStatement(sql);

            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassword());

        }catch(Exception ex){
            ex.printStackTrace();
        }finally {
            DBConfig.close(conn, ps);
        }
    }

    public User getUser(String userName) {
        User user = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DBConfig.connect(dbUrl, dbUser, dbPassword);
            String sql = "SELECT * FROM user WHERE user_name = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, userName);
            rs = ps.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setUserName(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConfig.close(conn, ps, rs);
        }

        return user;
    }
}
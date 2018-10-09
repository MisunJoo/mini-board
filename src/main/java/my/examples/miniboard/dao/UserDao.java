package my.examples.miniboard.dao;

import my.examples.miniboard.config.DBConfig;
import my.examples.miniboard.servlet.Article;
import my.examples.miniboard.servlet.User;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
                user.setId(rs.getLong(1));
                user.setUser_name(rs.getString(2));

                userList.add(user);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBConfig.close(conn, ps, rs);
        }

        return userList;
    }

    public int addUser(User user){
        int count = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = DBConfig.connect(dbUrl, dbUser, dbPassword);
            String sql = "insert into user (id, user_name, content, regdate)\n";
            ps = conn.prepareStatement(sql);

            //setString

            count = ps.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }finally {
            DBConfig.close(conn, ps);
        }
        return count;
    }





    }



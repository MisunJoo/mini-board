package my.examples.miniboard.servlet;

import my.examples.miniboard.dao.UserDao;
import my.examples.miniboard.dto.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/miniboard/signup")
public class MiniboardSignupServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/signup.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /* 아이디와 암호를 읽어들이기 */
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        List<User> userList = new ArrayList<>();
        String getName, getPassword;
        int count = 0;

        System.out.println(name + "/" + password);

        User user = new User(name, password);
        UserDao userDao = new UserDao();
        count = userDao.addUser(user);


        userList = userDao.getUserList();
        getName = userList.get(0).getName();
        getPassword = userList.get(0).getPassword();

        System.out.println(getName + "//" + getPassword);



        //메인화면으로 이동
        resp.sendRedirect("/");



    }
}

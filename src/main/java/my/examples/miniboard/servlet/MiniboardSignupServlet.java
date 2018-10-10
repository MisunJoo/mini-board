package my.examples.miniboard.servlet;

import my.examples.miniboard.dao.UserDao;

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
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        List<User> userList = new ArrayList<>();
        String getName, getPassword;

        System.out.println(userName + "/" + password);

        /* db에 회원 정보 추가 */
        User user = new User(userName, password);
        UserDao userDao = new UserDao();
        userList = userDao.getUserList();


        /* 중복 확인*/
        //if(userName == userD)

        /* 아이디 혹은 비밀번호를 입력하지 않음*/

        userDao.addUser(user);

        /* db에 추가한 회원 정보 확인. (첫 번쨰 값만) */
        userList = userDao.getUserList();
        getName = userList.get(0).getUserName();
        getPassword = userList.get(0).getPassword();

        System.out.println(getName + "//" + getPassword);



        /* 메인화면으로 이동 */
        resp.sendRedirect("/");



    }
}

package my.examples.miniboard.servlet;

import my.examples.miniboard.dao.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/miniboard/login")
public class MiniboardLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // login 페이지로 forwarding
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/login.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // login 페이지에서 id와 password를 받아,
        // id가 null이거나, DB에서 id로 얻은 user의 password와 입력받은 password가 일치하지 않으면 다시 login 페이지로 redirect
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        UserDao userDao = new UserDao();
        User user = userDao.getUser(userName, password);

        // 비밀번호 일치하지 않을 경우, login 페이지로 redirect
        if (!user.getPassword().equals(password)) {
            resp.sendRedirect("/miniboard/login");
        }
        // 비밀번호 일치할 경우, session에 user 정보 저장 후 index로 redirect
        else {
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("authUser", user);
            resp.sendRedirect("/"); // index로 redirect
        }
    }
}

package my.examples.miniboard.servlet;

import my.examples.miniboard.dao.ArticleDao;
import my.examples.miniboard.dto.Article;
import my.examples.miniboard.dto.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/miniboard/list")
public class MiniboardListServlet extends HttpServlet {

    String country;
    String category;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArticleDao articleDao = new ArticleDao();
        List<Article> articles = articleDao.getArticleList(country, category);

        req.setAttribute("articleList", articles);
        req.setAttribute("articleListSize", articles.size());

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/list.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("authUser");

        country = req.getParameter("country");
        category = req.getParameter("category");

//        ArticleDao articleDao = new ArticleDao(country, category);

        ArticleDao articleDao = new ArticleDao();


        //국가에 따른 리스틀 불러옴
        List<Article> list = articleDao.getArticleList(country, category);
        req.setAttribute("article", list);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/list.jsp");
        requestDispatcher.forward(req, resp);
    }
}

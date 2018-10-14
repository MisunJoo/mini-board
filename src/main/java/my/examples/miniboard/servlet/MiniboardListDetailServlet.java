package my.examples.miniboard.servlet;

import my.examples.miniboard.dao.ArticleDao;
import my.examples.miniboard.dto.Article;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/miniboard/list/detail")
public class MiniboardListDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long articleId = Long.parseLong(req.getParameter("id"));
        ArticleDao articleDao = new ArticleDao();
        Article article = articleDao.getArticle(articleId);
        req.setAttribute("article", article);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/articleDetail.jsp");
        dispatcher.forward(req, resp);
    }
}

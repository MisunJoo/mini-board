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
// ListServlet에서는 전체 글을 다 보여준다.
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArticleDao articleDao = new ArticleDao();

//        String country = req.getParameter("country");
//        String category = req.getParameter("category");

        //select로부터 읽어오는 것을 못함 ㅠㅠㅠㅠㅠㅠㅠㅠ
//        System.out.println("나라선택" + country);

        List<Article> allArticles = articleDao.getAllArticleList();

//        List<Article> articles = articleDao.getArticleList(country, category);
        req.setAttribute("articleList", allArticles);
        req.setAttribute("articleListSize", allArticles.size());
//        req.setAttribute("country", country);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/list.jsp");
        requestDispatcher.forward(req, resp);
    }

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("UTF-8");
//
//        HttpSession session = req.getSession();
//        User user = (User) session.getAttribute("authUser");
//
//        country = req.getParameter("country");
//        category = req.getParameter("category");
//
//        System.out.println("나라선택" + country);
//
////        ArticleDao articleDao = new ArticleDao(country, category);
//
//        ArticleDao articleDao = new ArticleDao();
//
//
//        //국가에 따른 리스틀 불러옴
//        List<Article> list = articleDao.getArticleList();
//        req.setAttribute("article", list);
//
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/list.jsp");
//        requestDispatcher.forward(req, resp);
//    }
}

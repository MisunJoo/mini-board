package my.examples.miniboard.servlet;

import my.examples.miniboard.dao.ArticleDao;
import my.examples.miniboard.dao.CommentDao;
import my.examples.miniboard.dto.Article;
import my.examples.miniboard.dto.Comment;
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

@WebServlet("/miniboard/delete")
public class MiniboardDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("authUser");
        Long commentId = Long.parseLong(req.getParameter("commentId"));
        Long articleId = Long.parseLong(req.getParameter("articleId"));

        ArticleDao articleDao = new ArticleDao();
        Article article = articleDao.getArticle(articleId);

        //댓글 삭제 후, 댓글 목록 다시 불러옴
        CommentDao commentDao = new CommentDao();
        boolean result = commentDao.deleteComment(commentId);
        List<Comment> commentList = commentDao.getCommentList(articleId);

        req.setAttribute("article", article);
        req.setAttribute("commentList", commentList);


        if(result) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/articleDetail.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
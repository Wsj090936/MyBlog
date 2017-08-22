package WebServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Article;
import domain.User;
import service_Implements.ArticleServiceImpl;
import service_Interface.ArticleService;



public class EditServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String date = request.getParameter("date1")+"-"+
					  request.getParameter("date2")+"-"+request.getParameter("date3");
		String content = request.getParameter("content");
		User user = (User) request.getSession().getAttribute("user");
		String username = user.getUsername();
		Article article = new Article();
		
		article.setId(id);
		article.setTitle(title);
		article.setUsername(username);
		article.setContent(content);
		article.setDate(date);
		ArticleService as = new ArticleServiceImpl();
		as.editArticle(article);
		
		request.getRequestDispatcher("/servlet/pageServlet").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

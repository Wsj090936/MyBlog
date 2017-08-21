package WebServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Article;
import service_Implements.ArticleServiceImpl;
import service_Interface.ArticleService;



public class findArticleByIdServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//获取表单数据
		String id = request.getParameter("id");
		ArticleService as = new ArticleServiceImpl();
		Article article = as.findArticleById(id);
		String date = article.getDate();
		String[] dates = date.split("-");
		request.setAttribute("date1", dates[0]);
		request.setAttribute("date2", dates[1]);
		request.setAttribute("date3", dates[2]);
		request.setAttribute("a", article);
		request.getRequestDispatcher("/edit.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}

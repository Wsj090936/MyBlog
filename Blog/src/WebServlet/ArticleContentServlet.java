package WebServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Article;
import service_Implements.ArticleServiceImpl;
import service_Interface.ArticleService;

public class ArticleContentServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//��ȡ������
		String id = request.getParameter("id");
		ArticleService as = new ArticleServiceImpl();
		Article article = as.findArticleById(id);//����id���ҵ�����
		
		request.setAttribute("look", article);//�����¶���request
		request.getRequestDispatcher("/articleContent.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}

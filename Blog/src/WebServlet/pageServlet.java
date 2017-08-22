package WebServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.PageBean;
import service_Implements.ArticleServiceImpl;
import service_Interface.ArticleService;

public class pageServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pageSize = 5;//每页显示5条
		int currentPage = 1;//当前页面
		
		String currpage = request.getParameter("currentPage");//点击上一页或下一页后获得的数据
		if(currpage != null){
			currentPage = Integer.parseInt(currpage);
		}
		ArticleService as = new ArticleServiceImpl();
		PageBean pb = as.findArticlesPage(currentPage,pageSize);//找到每页需要显示的文章并返回对象
		
		request.setAttribute("pb", pb);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}

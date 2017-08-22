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
		int pageSize = 5;//ÿҳ��ʾ5��
		int currentPage = 1;//��ǰҳ��
		
		String currpage = request.getParameter("currentPage");//�����һҳ����һҳ���õ�����
		if(currpage != null){
			currentPage = Integer.parseInt(currpage);
		}
		ArticleService as = new ArticleServiceImpl();
		PageBean pb = as.findArticlesPage(currentPage,pageSize);//�ҵ�ÿҳ��Ҫ��ʾ�����²����ض���
		
		request.setAttribute("pb", pb);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}

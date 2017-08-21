package WebServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Article;
import domain.User;
import exception.UsersException;
import service_Implements.ArticleServiceImpl;
import service_Implements.UserServiceImpl;
import service_Interface.ArticleService;
import service_Interface.UserService;

public class loginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//��ȡ������
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		UserService us = new UserServiceImpl();
		User u = null;
		try {
			u = us.login(user);//�õ������ݿ��в鵽�Ķ���
			//�ַ�ת��
			if(u != null){//��½�ɹ�
				request.getSession().setAttribute("user", user);
				request.getRequestDispatcher("/servlet/ArticleListServlet").forward(request, response);//�������²���Servlet
			}
		} catch (UsersException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			//��½ʧ��
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}

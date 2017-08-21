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
		//获取表单数据
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		UserService us = new UserServiceImpl();
		User u = null;
		try {
			u = us.login(user);//得到从数据库中查到的对象
			//分发转向
			if(u != null){//登陆成功
				ArticleService as = new ArticleServiceImpl();
				List<Article> articleList = as.findAllArticle();//将所有文章查找出来
				request.getSession().setAttribute("user", user);
				request.getSession().setAttribute("article", articleList);
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
		} catch (UsersException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			//登陆失败
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}

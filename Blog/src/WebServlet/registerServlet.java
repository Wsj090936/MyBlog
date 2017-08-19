package WebServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import service_Implements.UserServiceImpl;
import service_Interface.UserService;


public class registerServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		User user = new User();
		//��ȡ������
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		System.out.println(email);
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		//��������
		UserService us = new UserServiceImpl();
		try {
			us.register(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.getWriter().write("ע��ɹ���ҳ�潫��1�����ת");
		response.setHeader("refresh", "1;url="+request.getContextPath()+"/login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

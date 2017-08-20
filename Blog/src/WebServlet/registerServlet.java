package WebServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import domain.UserForm;
import exception.UserExistException;
import service_Implements.UserServiceImpl;
import service_Interface.UserService;


public class registerServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		User user = new User();//�洢������
		UserForm uf = new UserForm();//������֤�û��������
		//��ȡ������
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		String email = request.getParameter("email");
		
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		
		uf.setUsername(username);
		uf.setPassword(password);
		uf.setEmail(email);
		uf.setRepassword(repassword);
		if(!uf.checked()){//���msgMap���ϲ�Ϊ�գ���˵���û�����������д���
			request.setAttribute("uf", uf);
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			return;
		}
		//���û����������׼����������
		UserService us = new UserServiceImpl();
		try {
			us.findUserByName(user.getUsername());//�Ȳ��Ҹ��û��Ƿ��ѱ�ע��
			us.register(user);
		} catch (UserExistException e) {
			request.setAttribute("regMsg", e.getMessage());
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
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

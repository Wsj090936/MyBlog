package MyFilter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;

public class MyFilter2 implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String uri = req.getRequestURI();//  /Blog/xxx
		String path = req.getContextPath(); //  /Blog
		path = uri.substring(path.length());
		if(!("/servlet/loginServlet".equals(path) ||
			 "/servlet/regServlet".equals(path) ||
			 "/servlet/pageServlet".equals(path) ||
			 "/servlet/findArticleByIdServlet".equals(path) ||
			 "/servlet/articleContentServlet".equals(path))){
			User user = (User) req.getAttribute("user");
			if(user == null){
				req.getRequestDispatcher("/login.jsp").forward(req, resp);
				return;
			}
		}
			chain.doFilter(req, resp);//∑Ò‘Ú∑≈––

	}

}

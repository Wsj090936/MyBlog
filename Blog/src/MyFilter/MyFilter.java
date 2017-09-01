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

public class MyFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String uri = req.getRequestURI();//  /Blog/xxx
		String path = req.getContextPath(); //  /Blog
		path = uri.substring(path.length());
		if(!("/login.jsp".equals(path) || "/register.jsp".equals(path))){//如果不是先登陆  就不能进入其他页面
			User user = (User) req.getAttribute("user");
			if(user == null){
				if("/index.jsp".equals(path)){
					req.getRequestDispatcher("/servlet/pageServlet").forward(req, resp);
					return;
				}
				req.getRequestDispatcher("/login.jsp").forward(req, resp);
				return;
			}
		}
			chain.doFilter(req, resp);//否则放行
	}
	
}

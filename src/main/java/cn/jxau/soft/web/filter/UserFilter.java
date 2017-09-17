package cn.jxau.soft.web.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserFilter implements Filter {
	private String[] excluededUrls;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		excluededUrls = filterConfig.getInitParameter("excludedUrl").split(",");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String url = req.getServletPath();
		List<String> list = Arrays.asList(excluededUrls);
		if (list.size() > 0 && list.contains(url)) {
			chain.doFilter(request, response);
			return;
		}
		
		HttpSession session = req.getSession();
		if (session.getAttribute("loginedUser") != null) {
			chain.doFilter(request, response);
		} else {
			HttpServletResponse res = (HttpServletResponse) response;
			res.sendRedirect(req.getServletContext().getContextPath() + "/jsps/users/login.jsp");
		}
	}

	@Override
	public void destroy() {}

}

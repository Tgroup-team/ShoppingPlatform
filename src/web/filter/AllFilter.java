package web.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("*")
public class AllFilter implements Filter {

	// 静态文件不会被拦截
	private static final String[] staticFilesEndWiths = { ".css", ".js", ".png", ".jpg", ".jpeg", ".gif" };
	// 不需要登录的不会被拦截
	private static List<String> noInterceptRequestUri;

	public AllFilter() {
		noInterceptRequestUri = new ArrayList<String>();
		// 下面地址的请求，都不会检查是否登录
		noInterceptRequestUri.add("/index.html");// 首页
		noInterceptRequestUri.add("/Index");// 首页
		noInterceptRequestUri.add("/IntroductionServlet");// 商品介绍页
		noInterceptRequestUri.add("/IntroductionServletList");// 商品展示列表页
		noInterceptRequestUri.add("/userlogin.jsp");// 用户登陆页面
		noInterceptRequestUri.add("/userLoginServlet");// 用户登陆页面，提交登陆
		noInterceptRequestUri.add("/RegisterReqest");// 用户注册页面
		noInterceptRequestUri.add("/userRegisterServlet");// 用户注册页面，提交注册
		noInterceptRequestUri.add("/LoginServlet");// 管理员登陆页面
		noInterceptRequestUri.add("/ManagerServlet");// 管理员登陆页面，提交登陆
		noInterceptRequestUri.add("/ShowUserCart");// 购物车
		noInterceptRequestUri.add("/OrderSubmit");// 购买
		noInterceptRequestUri.add(".jsp");// 可以直接访问jsp
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		// 把服务请求转换成Http服务请求
		HttpServletRequest hRequest = (HttpServletRequest) request;
		String uri = hRequest.getRequestURI();
		String index_uri = hRequest.getContextPath() + "/";
		// 判断是不是访问的首页
		if (uri.endsWith(index_uri)) {
			chain.doFilter(request, response);
			return;
		}
		// 先判断是不是静态文件
		if (uri.contains(".")) {
			// 再判断是不是可以访问的静态文件
			String uri_lowCase = uri.toLowerCase();// 防止是大写的后缀被拦截
			for (int i = 0; i < staticFilesEndWiths.length; i++) {
				if (uri_lowCase.endsWith(staticFilesEndWiths[i])) {
					// 是就不拦截
					chain.doFilter(request, response);
					return;
				}
			}
		}
		// 判断是不是不登录就可以访问的url
		for (String string : noInterceptRequestUri) {
			if (uri.endsWith(string)) {
				// 是就不拦截
				chain.doFilter(request, response);
				return;
			}
		}
		// 看有没有相对应的请求响应
		boolean hasServletToResponse = false;
		String servletToResponse_className = "";
		Map<String, ? extends ServletRegistration> servletRegistrations = request.getServletContext()
				.getServletRegistrations();
		for (String string : servletRegistrations.keySet()) {
			ServletRegistration servletRegistration = servletRegistrations.get(string);
			servletToResponse_className = servletRegistration.getClassName();
			for (String string2 : servletRegistration.getMappings()) {
				if (uri.endsWith(string2)) {
					hasServletToResponse = true;
					break;
				}
			}
			if (hasServletToResponse) {
				break;
			}
		}
		if (hasServletToResponse) {// 有就判断是该登陆管理员还是用户
			if (servletToResponse_className.contains("user")) {
				if (hRequest.getSession().getAttribute("user") != null) {
					// 登录了就不拦截
					chain.doFilter(request, response);
					return;
				} else {
					//request.setAttribute("msg", "没有权限访问，用户，请您先<a href='userlogin.jsp'>登陆</a>");
					//request.getRequestDispatcher("/WEB-INF/404.jsp").forward(request, response);
					request.getRequestDispatcher("/userlogin.jsp").forward(request, response);
					return;
				}
			}
			if (servletToResponse_className.contains("admin")) {
				if (hRequest.getSession().getAttribute("admin") != null) {
					// 登录了就不拦截
					chain.doFilter(request, response);
					return;
				} else {
					request.setAttribute("msg", "没有权限访问，管理员，请您先<a href='LoginServlet'>登陆</a>");
					request.getRequestDispatcher("/WEB-INF/404.jsp").forward(request, response);
					//request.getRequestDispatcher("/LoginServlet").forward(request, response);
					return;
				}
			}
			request.setAttribute("msg", "登陆已失效，请重新登陆");
			request.getRequestDispatcher("/WEB-INF/404.jsp").forward(request, response);
			return;
		}
		// 没有就404
		request.setAttribute("msg", "页面不存在");
		request.getRequestDispatcher("/WEB-INF/404.jsp").forward(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	public void destroy() {
	}
}

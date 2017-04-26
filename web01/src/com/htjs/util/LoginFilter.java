package com.htjs.util;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) arg0;
		HttpServletResponse res = (HttpServletResponse) arg1;
		/*Map map = (Map) req.getSession().getAttribute("parameterMap");
		System.out.println("session中name="+map.get("name").toString());*/
		String name = req.getParameter("name");
//		System.out.println("过滤器"+name);
		if(name == null || "".equals(name)){
//			System.out.println("用户名为空");
			//res.sendRedirect("/web01/pages/login.jsp");
			arg2.doFilter(req, res);
		}else{
//			System.out.println("用户名="+name);
			arg2.doFilter(req, res);
			return;
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
//		System.out.println("过滤器init");
		
	}

}

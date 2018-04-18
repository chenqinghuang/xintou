package com.hn.sanya.xintou.config.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

    /**
　　* @Description: cookie过滤器
　  * @author syiti
	* @Method
　　* @params
　　* @return
　　* @date 2018/3/9 11:16
　　*/
	@WebFilter(filterName = "cookieFilter", urlPatterns = "/*",
			initParams = {
					@WebInitParam(name="exclusions",value="*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")// 忽略资源
			}
	)
public class CookieFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
        
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse rps = (HttpServletResponse)response;
		System.out.println("已加载到cookie过滤器...."+",请求地址"+req.getRequestURI());
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
	

}

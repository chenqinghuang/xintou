package com.hn.sanya.xintou.config.Interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 自定义拦截器
 * @author ZSX
 *
 */

@Component
public class LoginInterceptor implements HandlerInterceptor {

	private static Set<String> excludeUrls = new HashSet<String>(); // 不需要拦截的资源

	{
		// 排除配置

		excludeUrls.add("/city/findOneCity");
		excludeUrls.add("/user/login");
		excludeUrls.add("/city/findAllCity");
		excludeUrls.add("/user/loginCheck");
		excludeUrls.add("/user/index");
		excludeUrls.add("/user/login**");
		excludeUrls.add("/user/error");


	}
	
	/**
	 * 这个方法的主要作用是用于清理资源的，当然这个方法也只能在当前这个Interceptor的preHandle方法的返回值为true时才会执行。
	 */
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	/**
	 * 在Controller的方法调用之后执行
	 */
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	/** 
     * preHandle方法是进行处理器拦截用的，顾名思义，该方法将在Controller处理之前进行调用，
     * SpringMVC中的Interceptor拦截器是链式的，可以同时存在多个Interceptor，
     * 然后SpringMVC会根据声明的前后顺序一个接一个的执行，而且所有的Interceptor中的preHandle方法都会在Controller方法调用之前调用。
     * SpringMVC的这种Interceptor链式结构也是可以进行中断的，这种中断方式是令preHandle的返 
     * 回值为false，当preHandle的返回值为false的时候整个请求就结束了。 
     */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		HttpSession session = request.getSession();
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String url = requestURI.substring(contextPath.length() + 1);
		request.setAttribute("url", url);
		//判断是否是异步请求
		boolean isAjax = false;
		String requestType = request.getHeader("X-Requested-With");
		if (requestType != null && requestType.equals("XMLHttpRequest")) {// 异步
			isAjax = true;
		}


		System.out.println("请求url为：    " + requestURI);

		//判断是放行url
		if ("".equals(url) || validateUrls(url)) {
			return true;
		}


		//判断session用户是否未登录
		if (session.getAttribute("userName") == null) {
			if(isAjax){
				//未登录返回标识码
				response.setStatus(601);
			}else{
				response.setCharacterEncoding("UTF-8");
				response.setContentType("text/html;charset=UTF-8");
				response.sendRedirect(contextPath + "/user/login");
			}
			return false;
		}else{
			return true;
		}
	}

	/**
	 * 验证url是否在允许访问的url列表里面，即未登录既可以访问的url
	 * @param url
	 * @return
	 */
	private boolean validateUrls(String url) {
		url = "/" + url;

		if (excludeUrls.contains(url)) {
			return true;
		}
		for (String string : excludeUrls) {
			if (string.endsWith("*") &&
					url.indexOf(string.substring(0, string.length() - 1)) != -1) {
				return true;
			}
		}
		return false;
	}
	
}

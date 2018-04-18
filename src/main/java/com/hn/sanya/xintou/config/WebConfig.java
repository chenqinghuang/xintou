package com.hn.sanya.xintou.config;

import com.hn.sanya.xintou.config.Interceptor.LoginInterceptor;
import com.hn.sanya.xintou.config.Interceptor.PerformanceInterceptor;
import com.hn.sanya.xintou.config.filter.CookieFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
　　* @Description: 项目web配置
　  * @author syiti
    * @Method
　　* @params
　　* @return
　　* @date 2018/3/9 9:38
　　*/
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter{

    @Autowired
    private LoginInterceptor loginInterceptor;//登录拦截
    @Autowired
    private PerformanceInterceptor performanceInterceptor;//请求性能监控拦截
    /**
     * 登录session key
     */
    public final static String SESSION_KEY = "user";
    /**
　　* @Description: 加入自定义拦截器
　  * @author syiti
    * @Method addInterceptors
　　* @params registry
　　* @return void
　　* @date 2018/3/9 9:36
　　*/
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(loginInterceptor);
        registry.addInterceptor(performanceInterceptor);
        //registry.addInterceptor(performanceInterceptor).addPathPatterns("/**");
    }

    /**
　　* @Description: 配置自定义过滤器
　  * @author syiti
    * @Method someFilterRegistration
　　* @params null
　　* @return registration对象
　　* @date 2018/3/9 10:40
　　*/
    @Bean
    public FilterRegistrationBean someFilterRegistration() {
        //第一个过滤器
        FilterRegistrationBean registration = new FilterRegistrationBean();
        CookieFilter cookieFilter=new CookieFilter();
        registration.setFilter(cookieFilter);
        //registration.addUrlPatterns("/*");
        registration.addInitParameter("paramName", "paramValue");
        //优先级
        registration.setName("cookieFilter");
        registration.setOrder(1);
        return registration;
    }

    /**
     * 添加自定义的静态资源映射
     * 访问static 文件夹中的fengjing.jpg 图片的地址为 http://localhost:8080/static/fengjing.jpg
     * 这样使用代码的方式自定义目录映射，并不影响Spring Boot的默认映射，可以同时使用。
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        //registry.addResourceHandler("/**").addResourceLocations("/");
        super.addResourceHandlers(registry);
    }

    /**
     * @Description: SpringBoot添加支持CORS跨域访问(例如ajax异步跨域请求)
　　 addMapping：配置可以被跨域的路径，可以任意配置，可以具体到直接请求路径。
     allowedMethods：允许所有的请求方法访问该跨域资源服务器，如：POST、GET、PUT、DELETE等。
     allowedOrigins：允许所有的请求域名访问我们的跨域资源，可以固定单条或者多条内容，如："http://www.baidu.com"，只有百度可以访问我们的跨域资源。
     allowedHeaders：允许所有的请求header访问，可以自定义设置任意请求头信息，如："X-YAUTH-TOKEN"
　　*/
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("GET", "POST", "DELETE", "PUT")
                .allowedOrigins("*")
                .allowCredentials(true)
                .maxAge(3600);
    }


}

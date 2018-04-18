package com.hn.sanya.xintou.config.Interceptor;

import org.springframework.core.NamedThreadLocal;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
　　* @Description: 系统性能监控拦截
　  * @author syiti
    * @Method
　　* @params
　　* @return
　　* @date 2018/3/9 10:13
　　*/
@Component
public class PerformanceInterceptor implements HandlerInterceptor {

    //定义线程变量
    private NamedThreadLocal<Long> startTimeThreadLocal = new NamedThreadLocal<Long>("StopWatch-StartTime");

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        long beginTime = System.currentTimeMillis();//1、开始时间
        startTimeThreadLocal.set(beginTime);//线程绑定变量（该数据只有当前请求的线程可见）
        return true;//继续流程
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {
        long endTime = System.currentTimeMillis();//2、结束时间
        long beginTime = startTimeThreadLocal.get();//得到线程绑定的局部变量（开始时间）
        long consumeTime = endTime - beginTime;//3、消耗的时间
        if (consumeTime > 500) {//此处认为处理时间超过500毫秒的请求为慢请求
            //TODO 超时响应
            System.out.println("请求地址"+request.getRequestURI()+",执行时间超过500s-->"+consumeTime+",系统处理该请求"+request.getRequestURI()+"影响性能，及时优化处理");
        }else {
            //TODO 记录到日志文件
            System.out.println("请求地址"+request.getRequestURI()+",执行开始时间="+beginTime+",执行结束时间"+endTime+"-->消耗的时间"+ consumeTime);
        }

    }
}

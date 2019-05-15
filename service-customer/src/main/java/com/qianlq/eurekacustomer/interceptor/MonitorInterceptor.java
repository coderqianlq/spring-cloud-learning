package com.qianlq.eurekacustomer.interceptor;

import com.qianlq.eurekacustomer.util.LogUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author qianliqing
 * @date 2018-12-14 3:38 PM
 * mail: qianlq0824@gmail.com
 */

@Component
public class MonitorInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {
        httpServletRequest.setAttribute("startTime", System.currentTimeMillis());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler, ModelAndView modelAndView) throws Exception {
        LogUtils.info("耗时: " + (System.currentTimeMillis() - (long) httpServletRequest.getAttribute("startTime")) + "ms");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler, Exception e) throws Exception {
        LogUtils.info("耗时: " + (System.currentTimeMillis() - (long) httpServletRequest.getAttribute("startTime")) + "ms");
    }
}

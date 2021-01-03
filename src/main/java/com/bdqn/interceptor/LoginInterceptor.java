package com.bdqn.interceptor;

import com.bdqn.utils.SystemConstant;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //判断session是否为空
        if (request.getSession().getAttribute(SystemConstant.LOGINADMIN)==null){
            //没有登录，去到登录页面
            response.sendRedirect(request.getContextPath()+"/admin/login.html");
            return false;
        }
        //验证通过
            return true;
    }
}

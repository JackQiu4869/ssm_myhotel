package com.bdqn.servlet;

import com.bdqn.entity.SuperAdministrator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AdminLoginServlet",urlPatterns = "/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        response.setContentType("text/html;charset=UTF-8");
        //获取前台提交的管理员账户和密码
        String username=request.getParameter("username");
        String password=request.getParameter("password");

        SuperAdministrator superAdministrator=(SuperAdministrator) request.getSession().getAttribute("loginAdmin");



        //判断applicant == null,返回登录页面，不为空，就进入主页面
        if (superAdministrator!=null){
            if (superAdministrator.getPassword().equals(password)){
                //将登录用户对象保存到session
                request.getSession().setAttribute("SESSION_ADMIN",superAdministrator);
                request.getSession().setAttribute("SESSION_ID",superAdministrator.getId());
                response.sendRedirect("/admin/home.html");
            }
        }else{
            PrintWriter writer = response.getWriter();
            writer.write("<script>");
            writer.write("alert('用户名或密码错误!');");
            writer.write("window.location.href='admin/login.html'");
            writer.write("</script>");
            writer.flush();
            writer.close();
        }



    }
}

package com.xworkz.Quick.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(loadOnStartup = 1,urlPatterns = "/redirectToRegister")
public class RedirectToRegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet in RedirectToRegisterServlet");

        RequestDispatcher requestDispatcher=req.getRequestDispatcher("register.jsp");
        requestDispatcher.forward(req,resp);
    }
}

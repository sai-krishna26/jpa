package com.xworkz.Quick.servlet;

import com.xworkz.Quick.dto.RegisterDto;
import com.xworkz.Quick.service.RegisterService;
import com.xworkz.Quick.service.impl.RegisterServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(urlPatterns = "/relocateToRegister")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet in RegisterServlet");
        RequestDispatcher requestDispatcher=req.getRequestDispatcher("register.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost in RegisterServlet");
        RegisterDto registerDto=new RegisterDto();
        registerDto.setName(req.getParameter("name"));
        registerDto.setEmail(req.getParameter("email"));
        registerDto.setPassword(req.getParameter("password"));
        registerDto.setConfirmPassword(req.getParameter("confirmPassword"));
        registerDto.setGraduationDate(LocalDate.parse(req.getParameter("graduationDate")));
        registerDto.setInstitute(req.getParameter("institute"));

        System.out.println(registerDto);

        RegisterService registerService=new RegisterServiceImpl();
        Boolean result=registerService.validateAndsSave(registerDto);

        if(result==true)
        {
            System.out.println("RegisterDto is saved successfully");
            RequestDispatcher requestDispatcher=req.getRequestDispatcher("register.jsp");
            requestDispatcher.forward(req,resp);
        }
        else
        {
            System.out.println("RegisterDto is not saved");
            RequestDispatcher requestDispatcher=req.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(req,resp);
        }
    }
}

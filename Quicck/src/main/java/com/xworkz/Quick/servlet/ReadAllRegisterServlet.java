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
import java.util.List;

@WebServlet(loadOnStartup = 1, urlPatterns = "/readAllRegister")
public class ReadAllRegisterServlet extends HttpServlet {

    RegisterService registerService=new RegisterServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet in ReadAllRegisterServlet");
        List<RegisterDto> registerDtoList=registerService.validateAndReadAll();

        System.out.println(registerDtoList);
        req.setAttribute("registerDtoList",registerDtoList);
       RequestDispatcher requestDispatcher= req.getRequestDispatcher("readAllRegister.jsp");
       requestDispatcher.forward(req,resp);
    }
}

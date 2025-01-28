package com.xworkz.form.servlet;

import com.xworkz.form.dto.FormDto;
import com.xworkz.form.service.FormService;
import com.xworkz.form.service.FormServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/signin")
public class AddDataServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String securityQuestion = req.getParameter("securityQuestion");
        String securityAnswer = req.getParameter("securityAnswer");
        String country = req.getParameter("country");

        FormDto formDto = new FormDto();
        formDto.setUsername(username);
        formDto.setPassword(password);
        formDto.setSecurityQuestion(securityQuestion);
        formDto.setSecurityAnswer(securityAnswer);
        formDto.setCountry(country);

        FormService formService = new FormServiceImpl();
        formService.validateAndSave(formDto);

//        PrintWriter printWriter = resp.getWriter();
//        printWriter.write("Thank you "+username +" for registering");

        req.setAttribute("username",username);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("response.jsp");
        requestDispatcher.forward(req,resp);
    }
}

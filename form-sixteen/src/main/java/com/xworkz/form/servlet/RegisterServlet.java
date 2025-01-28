package com.xworkz.form.servlet;

import com.xworkz.form.dto.FormDto;
import com.xworkz.form.service.FormService;
import com.xworkz.form.service.FormServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/signin")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String gender = req.getParameter("gender");

        FormDto formDto = new FormDto();
        formDto.setUsername(username);
        formDto.setPassword(password);
        formDto.setEmail(email);
        formDto.setGender(gender);

        FormService formService = new FormServiceImpl();
        formService.validateAndSave(formDto);

        PrintWriter printWriter = resp.getWriter();
        printWriter.write("Thank you "+username +" for registering");
    }
}

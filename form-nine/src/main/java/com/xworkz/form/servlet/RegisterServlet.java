package com.xworkz.form.servlet;

import com.xworkz.form.servlet.dto.FormDto;
import com.xworkz.form.servlet.service.FormService;
import com.xworkz.form.servlet.service.FormServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String cEmail = req.getParameter("cEmail");
        String password = req.getParameter("password");
        String cPassword = req.getParameter("cPassword");
        String dob = req.getParameter("dob");
        String age = req.getParameter("age");

        FormDto formDto = new FormDto();
        formDto.setEmail(email);
        formDto.setCEmail(cEmail);
        formDto.setPassword(password);
        formDto.setDob(dob);
        formDto.setAge(Integer.parseInt(age));
        FormService formService = new FormServiceImpl();
        formService.validateAndSave(formDto);


        PrintWriter printWriter = resp.getWriter();
        printWriter.write("Thank you "+email +" for registering");
    }
}

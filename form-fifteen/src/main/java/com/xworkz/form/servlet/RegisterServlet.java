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

@WebServlet(urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String qualification = req.getParameter("qualification");
        String email = req.getParameter("email");
        String city = req.getParameter("city");

        FormDto formDto = new FormDto();
        formDto.setName(name);
        formDto.setQualification(qualification);
        formDto.setEmail(email);
        formDto.setCity(city);

        FormService formService = new FormServiceImpl();
        formService.validateAndSave(formDto);

        PrintWriter printWriter = resp.getWriter();
        printWriter.write("Thank you "+name +" for registering");
    }
}

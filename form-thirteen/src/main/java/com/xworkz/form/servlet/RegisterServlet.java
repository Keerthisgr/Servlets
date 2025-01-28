package com.xworkz.form.servlet;

import com.xworkz.form.dto.FormDto;
import com.xworkz.form.service.FormService;
import com.xworkz.form.service.FormServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String address = req.getParameter("address");
        String pincode = req.getParameter("pincode");

        FormDto formDto = new FormDto();
        formDto.setFirstName(firstName);
        formDto.setLastName(lastName);
        formDto.setAddress(address);
        formDto.setPincode(Integer.parseInt(pincode));

        FormService formService = new FormServiceImpl();
        formService.validateAndSave(formDto);

        PrintWriter printWriter = resp.getWriter();
        printWriter.write("Thank you "+firstName +" for registering");
    }
}

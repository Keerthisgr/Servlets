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

@WebServlet(urlPatterns = "/addProfile")
public class AddProfileServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String cNo = req.getParameter("cNo");

        FormDto formDto = new FormDto();
        formDto.setFirstName(firstName);
        formDto.setLastName(lastName);
        formDto.setEmail(email);
        formDto.setCNo(Long.parseLong(cNo));
        FormService formService = new FormServiceImpl();
        formService.validateAndSave(formDto);
        PrintWriter printWriter = resp.getWriter();
        printWriter.write("Thank you "+firstName +" for registering");
    }
}

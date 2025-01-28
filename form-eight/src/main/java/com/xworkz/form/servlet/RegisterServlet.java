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

@WebServlet(urlPatterns = "/addInfo")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
         String middleName = req.getParameter("middleName");
         String lastName = req.getParameter("lastName");
         String cNo = req.getParameter("cNo");
         String email = req.getParameter("email");
         String address = req.getParameter("address");

        FormDto formDto = new FormDto();
        formDto.setFirstName(firstName);
        formDto.setMiddleName(middleName);
        formDto.setLastName(lastName);
        formDto.setCNo(Long.parseLong(cNo));
        formDto.setEmail(email);
        formDto.setAddress(address);

        FormService formService = new FormServiceImpl();
        formService.validateAndSave(formDto);

        PrintWriter printWriter = resp.getWriter();
        printWriter.write("Thank you "+firstName +" for registering");
        printWriter.write(lastName);
    }
}

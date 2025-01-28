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

@WebServlet(urlPatterns = "/register")
public class AddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String dob = req.getParameter("dob");
        String phone = req.getParameter("phone");
        String gender = req.getParameter("gender");
       String  aadhar = req.getParameter("aadhar");
        String  address= req.getParameter("address");

        FormDto formDto = new FormDto();
       formDto.setFirstName(firstName);
       formDto.setLastName(lastName);
       formDto.setEmail(email);
       formDto.setDob(dob);
       formDto.setPhone(Long.parseLong(phone));
       formDto.setGender(gender);
       formDto.setAadhar(Long.parseLong(aadhar));
       formDto.setAddress(address);

        FormService formService = new FormServiceImpl();
        formService.validateAndSave(formDto);

        req.setAttribute("firstName",firstName);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("response.jsp");
        requestDispatcher.forward(req,resp);
//        PrintWriter printWriter = resp.getWriter();
//        printWriter.write("Thank you "+firstName +" for registering");
    }
}

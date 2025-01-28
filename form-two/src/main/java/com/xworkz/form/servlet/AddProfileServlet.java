package com.xworkz.form.servlet;

import com.xworkz.form.servlet.dto.FormDto;
import com.xworkz.form.servlet.service.FormService;
import com.xworkz.form.servlet.service.FormServiceImpl;

import javax.servlet.RequestDispatcher;
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
        String fullName = req.getParameter("fullName");
        String email = req.getParameter("email");
        String mobile = req.getParameter("mobile");
        String gender = req.getParameter("gender");
        String dob = req.getParameter("dob");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");

        FormDto formDto = new FormDto();
        formDto.setFullName(fullName);
        formDto.setEmail(email);
        formDto.setMobile(Long.parseLong(mobile));
        formDto.setGender(gender);
        formDto.setDob(dob);
        formDto.setPassword(password);
        formDto.setConfirmPassword(confirmPassword);

        FormService formService = new FormServiceImpl();
        formService.validateAndSave(formDto);

//        PrintWriter printWriter = resp.getWriter();
//        printWriter.write("Thank you "+fullName +" for registering");

        req.setAttribute("fullName",fullName);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("response.jsp");
        requestDispatcher.forward(req,resp);
    }
    }


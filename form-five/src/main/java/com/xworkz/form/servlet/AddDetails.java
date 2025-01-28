package com.xworkz.form.servlet;

import com.xworkz.form.servlet.dto.FormFiveDto;
import com.xworkz.form.servlet.service.FormFiveService;
import com.xworkz.form.servlet.service.FormFiveServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/addDetails")
public class AddDetails extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String name = req.getParameter("name");
            String fatherName = req.getParameter("fatherName");
            String dob = req.getParameter("dob");
            String cNo = req.getParameter("cNo");
            String bGroup = req.getParameter("bGroup");
            String qualification = req.getParameter("qualification");

        FormFiveDto formFiveDto = new FormFiveDto();
        formFiveDto.setName(name);
        formFiveDto.setFatherName(fatherName);
        formFiveDto.setDob(dob);
        formFiveDto.setCNo(Long.parseLong(cNo));
        formFiveDto.setBGroup(bGroup);
        formFiveDto.setQualification(qualification);

        FormFiveService formFiveService = new FormFiveServiceImpl();
        formFiveService.validateAndSave(formFiveDto);
            PrintWriter printWriter = resp.getWriter();
            printWriter.write("Thank you " + name + " for registering");
        }
    }


package com.xworkz.form.servlet;

import com.xworkz.form.servlet.dto.FormFourDto;
import com.xworkz.form.servlet.service.FormFourService;
import com.xworkz.form.servlet.service.FormFourServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/addData")
public class AddDataServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String fatherName = req.getParameter("fatherName");
        String motherName = req.getParameter("motherName");
        String cNo = req.getParameter("cNo");
        String address = req.getParameter("address");
        String qualification = req.getParameter("qualification");

        FormFourDto formFourDto = new FormFourDto();
        formFourDto.setName(name);
        formFourDto.setFatherName(fatherName);
        formFourDto.setMotherName(motherName);
        formFourDto.setCNo(Long.parseLong(cNo));
        formFourDto.setAddress(address);
        formFourDto.setQualification(qualification);

        FormFourService formFourService = new FormFourServiceImpl();
        formFourService.validateAndSave(formFourDto);

        PrintWriter printWriter = resp.getWriter();
        printWriter.write("Thank you " + name + " for registering");
    }
}

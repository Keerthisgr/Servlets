package com.xworkz.form.servlet;

import com.xworkz.form.servlet.dto.FormSevenDto;
import com.xworkz.form.servlet.service.FormSevenService;
import com.xworkz.form.servlet.service.FormSevenServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/signUp")
public class SignUpServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String fatherName = req.getParameter("fatherName");
        String motherName = req.getParameter("motherName");
        String cNo = req.getParameter("cNo");
        String address = req.getParameter("address");
        String qualification = req.getParameter("qualification");
        FormSevenDto formSevenDto = new FormSevenDto();
        formSevenDto.setName(name);
        formSevenDto.setFatherName(fatherName);
        formSevenDto.setMotherName(motherName);
        formSevenDto.setCNo(Long.parseLong(cNo));
        formSevenDto.setAddress(address);
        formSevenDto.setQualification(qualification);

        FormSevenService formSevenService = new FormSevenServiceImpl();
        formSevenService.validateAndSave(formSevenDto);
        PrintWriter printWriter = resp.getWriter();
        printWriter.write("Thank you " + name + " for registering");
    }
}

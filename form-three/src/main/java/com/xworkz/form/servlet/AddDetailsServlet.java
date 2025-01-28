package com.xworkz.form.servlet;

import com.xworkz.form.servlet.dto.FormThreeDto;
import com.xworkz.form.servlet.service.FormThreeService;
import com.xworkz.form.servlet.service.FormThreeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(urlPatterns = "/addDetails")
public class AddDetailsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String email = req.getParameter("email");
        String cNo = req.getParameter("cNo");
        String address = req.getParameter("address");
        String city = req.getParameter("city");

        FormThreeDto formThreeDto = new FormThreeDto();
        formThreeDto.setName(name);
        formThreeDto.setAge(Integer.parseInt(age));
        formThreeDto.setEmail(email);
        formThreeDto.setCNo(Long.parseLong(cNo));
        formThreeDto.setAddress(address);
        formThreeDto.setCity(city);

        FormThreeService formThreeService = new FormThreeServiceImpl();
        formThreeService.validateAndSave(formThreeDto);
        PrintWriter printWriter = resp.getWriter();
        printWriter.write("Thank you " + name + " for registering");
    }
}

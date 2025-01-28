package com.xworkz.form.servlet;

import com.xworkz.form.dto.UserProfileDto;
import com.xworkz.form.entity.UserProfileEntity;
import com.xworkz.form.repository.UserProfileRepository;
import com.xworkz.form.repository.UserProfileRepositoryImpl;
import com.xworkz.form.service.UserProfileService;
import com.xworkz.form.service.UserProfileServiceImpl;
import sun.plugin.util.UserProfile;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/addProfile")
public class AddProfileServlet extends HttpServlet {

//    UserProfileRepository userProfileRepository = new UserProfileRepositoryImpl();


    public AddProfileServlet(){
        System.out.println("Add profile constructor");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String cNo = req.getParameter("cNo");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        String city = req.getParameter("city");


        UserProfileDto userProfileDto = new UserProfileDto();
        userProfileDto.setFirstName(firstName);
        userProfileDto.setLastName(lastName);
        userProfileDto.setCNo(Long.parseLong(cNo));
        userProfileDto.setEmail(email);
        userProfileDto.setAddress(address);
        userProfileDto.setCity(city);


        UserProfileService userProfileService = new UserProfileServiceImpl();
        userProfileService.saveAndValidate(userProfileDto);


        PrintWriter printWriter = resp.getWriter();
        printWriter.write("Thank you "+firstName +" for registering");

    }
}

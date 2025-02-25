package com.xworkz.foodapp.servlet;

import com.xworkz.foodapp.dto.UserProfileDto;
import com.xworkz.foodapp.service.UserProfileService;
import com.xworkz.foodapp.service.UserProfileServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/getAllProfiles")
public class GetAllProfilesServlet extends HttpServlet {
    public GetAllProfilesServlet() {
        System.out.println("Instantiation phase started: GetAllProfilesServlet constructor invoked!!");
    }
    @Override
    public void init() throws ServletException {
        System.out.println("Initialization phase started: servlet object is created");
    }

    @Override
    public void destroy() {
        System.out.println("destroy phase started: closes all costly resources");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserProfileService service = new UserProfileServiceImpl();
        List<UserProfileDto> userProfileDtoList = service.getAllProfiles();

//        PrintWriter writer = resp.getWriter();
//        writer.write(userProfileDtoList.toString());

        req.setAttribute("listOfProfiles", userProfileDtoList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("getAllProfiles.jsp");
        dispatcher.forward(req, resp);
    }
}

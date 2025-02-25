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

@WebServlet(urlPatterns = "/getProfile")
public class GetProfileServlet extends HttpServlet {
    public GetProfileServlet() {
        System.out.println("Instantiation phase started: GetProfileServlet constructor invoked!!");
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
        String id = req.getParameter("userId");

        UserProfileService service = new UserProfileServiceImpl();
        UserProfileDto dto = service.getProfileById(Integer.parseInt(id));
        System.out.println(dto);
        req.setAttribute("userProfile",dto);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("UpdateProfile.jsp");
        requestDispatcher.forward(req,resp);
    }
}

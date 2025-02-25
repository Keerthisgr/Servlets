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
@WebServlet(urlPatterns = "/updateProfile")
public class UpdateProfileServlet extends HttpServlet {
    public UpdateProfileServlet() {
        System.out.println("Instantiation phase started: UpdateProfileServlet constructor invoked!!");
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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId=req.getParameter("userId");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("emailId");
        String phNumber = req.getParameter("phNumber");

        UserProfileDto dto = new UserProfileDto();
        dto.setUserId(Integer.parseInt(userId));
        dto.setFirstName(firstName);
        dto.setLastName(lastName);
        dto.setEmail(email);
        dto.setPhNumber(Long.parseLong(phNumber));

        UserProfileService service = new UserProfileServiceImpl();
        boolean isUserProfileUpdated = service.updateProfile(dto);
        if (isUserProfileUpdated){
            req.setAttribute("updateMsg","User Profile Updated successfully");
        }else req.setAttribute("updateMsg","User Profile could not be Updated.. try again later");

        RequestDispatcher rd = req.getRequestDispatcher("UpdateProfile.jsp");
        rd.forward(req,resp);
    }
}

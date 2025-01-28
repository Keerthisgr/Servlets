import com.xworkz.form.dto.FormDto;
import com.xworkz.form.service.FormService;
import com.xworkz.form.service.FormServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/add")
public class AddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fullName = req.getParameter("fullName");
        String email = req.getParameter("email");
        String dob = req.getParameter("dob");
        String phone = req.getParameter("phone");
        String nationality = req.getParameter("nationality");
        FormDto formDto = new FormDto();
        formDto.setFullName(fullName);
        formDto.setEmail(email);
        formDto.setDob(dob);
        formDto.setPhone(Long.parseLong(phone));
        formDto.setNationality(nationality);

        FormService formService = new FormServiceImpl();
        formService.validateAndSave(formDto);


        PrintWriter printWriter = resp.getWriter();
        printWriter.write("Thank you "+fullName +" for registering");
    }
}

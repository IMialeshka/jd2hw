import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class PersonalInformation extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String ErrMass = "";
        if(name.length() == 0){
            ErrMass = ErrMass + "Name is not filled.\n";
        }
        if((phone.length() == 0) && (email.length() == 0)){
            ErrMass = ErrMass + "Phone number or email is not filled.";
        }
        if(ErrMass.length() == 0)
        {
            out.println("Name = " + name + " Phone = " + phone + " E-mail = "+email);
        }
        else
        {
            out.println(ErrMass);
        }
    }
}

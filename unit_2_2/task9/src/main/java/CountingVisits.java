import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CountingVisits extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        PrintWriter out = resp.getWriter();
        try{
            int countVisit = Integer.parseInt(LogVisits.read());
            countVisit ++;
            LogVisits.write(countVisit);
            out.println(countVisit);
        } catch (NumberFormatException e){
            LogVisits.write(0);
            out.println("Counter reset.");
        }

    }

}

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CountingVisits extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();
        LogVisits logVisits = new LogVisits();
        logVisits.dellPLog();

        String cookieName = "MyCookieCount";
        Cookie[] cookies = req.getCookies();


        boolean isNewUser = true;

        if(cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookieName.equals(cookie.getName())) {
                    isNewUser = false;
                    break;
                }
            }
        }


        int countVisit = 0;
        try{
            countVisit = Integer.parseInt(logVisits.read());
        } catch (NumberFormatException e){
            out.println("Counter reset.");
        }


        if(isNewUser){
            Cookie myCookie = new Cookie(cookieName, "valueCookie");
            Calendar calendar = new GregorianCalendar();
            int timeS = (calendar.get(Calendar.HOUR)*60+calendar.get(Calendar.MINUTE))*60 + calendar.get(Calendar.SECOND);
            myCookie.setMaxAge(24*60*60-timeS);
            resp.addCookie(myCookie);
            countVisit ++;
        }
        logVisits.write(countVisit);
        out.println(countVisit);


    }

}

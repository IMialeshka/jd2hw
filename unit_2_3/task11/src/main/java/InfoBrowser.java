import eu.bitwalker.useragentutils.UserAgent;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class InfoBrowser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        String myBrowser = UserAgent.parseUserAgentString(req.getHeader("User-Agent")).getBrowser().getName();
        out.println("Приветствую пользователя " + myBrowser);
    }
}

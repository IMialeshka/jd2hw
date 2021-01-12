import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class ExpensesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();
        ServletConfig conf = getServletConfig();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection =  DriverManager.getConnection(conf.getInitParameter("database.URL"), conf.getInitParameter("database.login"), conf.getInitParameter("database.password"));
            final Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT `expenses`.`num`,\n" +
                    "    `expenses`.`paydate`,\n" +
                    "    `expenses`.`receiver`,\n" +
                    "    `expenses`.`value`\n" +
                    "FROM `listexpenses`.`expenses`;");
            while (resultSet.next()){
                out.println("num = " + resultSet.getInt(1) + " paydate =" + resultSet.getDate(2) +
                        " receiver ="+ resultSet.getInt(3) + " value = "+resultSet.getFloat(4));
            }
            statement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            out.println("There is no connection. Try later.");
        }
    }
}

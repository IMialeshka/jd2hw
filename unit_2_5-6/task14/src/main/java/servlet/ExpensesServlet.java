package servlet;

import data.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

public class ExpensesServlet extends HttpServlet {
    DaoFactory daoFactory;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        final String databaseName = config.getServletContext().getInitParameter("database.name");
        try {
            daoFactory = DaoFactory.getInstance(DatabaseName.valueOf(databaseName));
        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletConfig config = getServletConfig();
        try {
            ExpensesDao expensesDao = daoFactory.getExpensesDao(config);
            List<Expenses> expensesList = expensesDao.readAll();
            req.setAttribute("result", expensesList);
            req.getRequestDispatcher("/resultAll.jsp").forward(req, resp);
        } catch (SQLException throwables) {
            PrintWriter out = resp.getWriter();
            out.println("Houston we have a problem!");

        }
    }
}

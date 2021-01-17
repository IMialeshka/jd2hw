package data;

import javax.servlet.ServletConfig;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoFactory {
    private static DaoFactory daoFactory;

    private DaoFactory() throws ClassNotFoundException {
      Class.forName("com.mysql.cj.jdbc.Driver");
    }

    public ExpensesDao getExpensesDao(ServletConfig conf) throws SQLException {
        Connection connection = DriverManager.getConnection(conf.getInitParameter("database.URL"), conf.getInitParameter("database.login"), conf.getInitParameter("database.password"));
        return new ExpensesDaoImpl(connection);
    }

    public static DaoFactory getInstance(DatabaseName databaseName) throws ClassNotFoundException {
        switch (databaseName){
            case MYSQL:{
                if(daoFactory == null){
                    daoFactory = new DaoFactory();
                }
                return daoFactory;
            }
            case ORACLE:{
              return null;
            }
        }
        throw new IllegalArgumentException("Unknown database");
    }


}

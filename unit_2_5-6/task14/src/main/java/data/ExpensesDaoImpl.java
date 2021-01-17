package data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExpensesDaoImpl implements ExpensesDao{

    private final Connection connection;

    public ExpensesDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Expenses productSpec) {

    }

    @Override
    public Expenses read(int id) {
        return null;
    }

    @Override
    public List<Expenses> readAll() {
        List<Expenses> expenses = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("select * from listexpenses.expenses")) {
            while (resultSet.next()) {
                Expenses expense = new Expenses();
                expense.setNum(resultSet.getInt("num"));
                expense.setPaydate(resultSet.getDate("paydate"));
                expense.setReceiver(resultSet.getInt("receiver"));
                expense.setValue(resultSet.getDouble("value"));
                expenses.add(expense);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return expenses;
    }

    @Override
    public void update(Expenses productSpec) {

    }

    @Override
    public void delete(Integer id) {  }
}

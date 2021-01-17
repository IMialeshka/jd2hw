package data;

import java.util.List;

public interface ExpensesDao {
    void create(Expenses expense);

    Expenses read(int id);

    List<Expenses> readAll();

    void update(Expenses expense);

    void delete(Integer id);
}

package it.academy.testdata;

import java.math.BigDecimal;
import java.util.List;

public class ManagerDaoImpl implements ManagerDao{
    private static  List<Manager> managers = List.of(new Manager(1, "Manager 1", BigDecimal.valueOf(100.0), BigDecimal.valueOf(120.0)),
            new Manager(2, "Manager 2", BigDecimal.valueOf(200.0), BigDecimal.valueOf(220.0)),
            new Manager(3, "Manager 3", BigDecimal.valueOf(300.0), BigDecimal.valueOf(320.0)));

    @Override
    public List<Manager> findAllManager() {
        return managers;
    }
}

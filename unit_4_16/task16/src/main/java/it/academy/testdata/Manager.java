package it.academy.testdata;

import java.math.BigDecimal;

public class Manager {
    Integer id;
    String name;
    BigDecimal salary;
    BigDecimal premium;

    public Manager(Integer id, String name, BigDecimal salary, BigDecimal premium) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.premium = premium;
    }
}

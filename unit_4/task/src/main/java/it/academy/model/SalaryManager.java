package it.academy.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;


@Getter
@Setter
@ToString
@Component("salarymanager")
public class SalaryManager implements ISalary{
    @Value("100.0")
    private BigDecimal salary;
    @Value("250.0")
    private BigDecimal premium1;
    @Value("200.0")
    private BigDecimal premium2;
}

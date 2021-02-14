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
@Component("salarydirector")
public class SalaryDirector implements ISalary{
    @Value("1000.0")
    private BigDecimal salary;
}

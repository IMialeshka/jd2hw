package it.academy.model;

import it.academy.anotation.ManagerSalary;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class Manager {
    Person person;

    @Autowired(required=false)
    @ManagerSalary
    ISalary salary;
}

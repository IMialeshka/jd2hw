package it.academy.utils;

import it.academy.anotation.ManagerSalary;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;


@ComponentScan(value = "it.academy.model", includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = ManagerSalary.class))
public class Config {

}

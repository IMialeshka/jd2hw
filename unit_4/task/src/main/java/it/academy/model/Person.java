package it.academy.model;

import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@Component
public class Person {
    private String name;
    private Integer age;
}

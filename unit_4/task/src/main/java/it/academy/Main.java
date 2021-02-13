package it.academy;

import it.academy.model.Manager;
import it.academy.utils.Config;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Manager manager = context.getBean(Manager.class);
        System.out.println(manager.getSalary());
    }
}

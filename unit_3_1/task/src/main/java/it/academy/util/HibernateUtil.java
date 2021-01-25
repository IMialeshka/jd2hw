package it.academy.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    private final  Session session;

    public HibernateUtil() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        SessionFactory factory = new MetadataSources(registry)
                .buildMetadata()
                .buildSessionFactory();
        session = factory.openSession();
    }

    public Session getSession() {
        return session;
    }

    public void closeSession(){
        session.close();
   }
}

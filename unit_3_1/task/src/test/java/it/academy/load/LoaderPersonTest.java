package it.academy.load;

import it.academy.pojos.Persons;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@FixMethodOrder
public class LoaderPersonTest {
    private SessionFactory factory;
    @org.junit.Before
    public void setUp(){
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.test.xml")
                .build();
        factory = new MetadataSources(registry)
                .buildMetadata()
                .buildSessionFactory();
    }

    @Test
    public  void create(){
        Persons person = new Persons();
        person.setId(null);
        person.setName("Natalia");
        person.setSurname("Ivanova");
        person.setAge(1);
        Session sess = factory.openSession();
        LoaderPerson.savePerson(person, sess);
        Transaction tx = null;
        Persons res;
        try {
            tx = sess.beginTransaction();
            res = sess.get(Persons.class, person.getId());
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            sess.close();
        }

        assertNotNull(res);
    }

    @Test
    public  void dell(){
        Persons person = new Persons();
        person.setId(null);
        person.setName("Natalia");
        person.setSurname("Petrova");
        person.setAge(1);
        Session sess = factory.openSession();
        Transaction tx = null;
        Persons res;
        try {
            tx = sess.beginTransaction();
            sess.save(person);
            tx.commit();
            Integer id = person.getId();
            LoaderPerson.dellPerson(person, sess);
            res = sess.get(Persons.class, id);
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            sess.close();
        }

        assertNull(res);
    }

    @Test
    public  void get(){
        Persons person = new Persons();
        person.setId(null);
        person.setName("Natalia");
        person.setSurname("Petrova");
        person.setAge(5);
        Session sess = factory.openSession();
        Transaction tx = null;
        Persons res;
        Persons rese;
        try {
            tx = sess.beginTransaction();
            sess.save(person);
            tx.commit();
            Integer id = person.getId();
            res = sess.get(Persons.class, id);
            rese = LoaderPerson.getPerson(id, sess);
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            sess.close();
        }

        Assert.assertEquals(res, rese);
    }

    @org.junit.After
    public void tearDown() {
        factory.close();
    }
}
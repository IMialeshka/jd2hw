package it.academy.load;

import it.academy.pojos.Persons;
import it.academy.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class LoaderPerson {
    public static void main(String[] args) {
        HibernateUtil hibernateUtil = new HibernateUtil();
        Session sess = hibernateUtil.getSession();
        Persons person = new Persons();
        person.setId(null);
        person.setName("Inna");
        person.setSurname("Mialeshka");
        person.setAge(35);

        int id = savePerson(person, sess);
        Persons personDell = getPerson(id, sess);
        if(personDell != null){
            dellPerson(personDell, sess);
        }
        hibernateUtil.closeSession();
    }

    public static int savePerson(Persons person, Session sess){

        Transaction tx = null;
        try {
            tx = sess.beginTransaction();
            sess.save(person);
            tx.commit();
            sess.refresh(person);
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
       return person.getId();
    }

    public static void dellPerson(Persons person, Session sess){
        Transaction tx = null;
        try {
            tx = sess.beginTransaction();
            sess.delete(person);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }

    }

    public static Persons getPerson(Integer id, Session sess){
        Persons result;
        if(sess.isDirty())  sess.flush();
        result = sess.get(Persons.class, id);
        return result;
    }

}

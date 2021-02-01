package it.academy.load;

import it.academy.pojos.Address;
import it.academy.pojos.Persons;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class LoaderAddress {
    public static void saveAddress(Address address, Session sess){

        Transaction tx = null;
        try {
            tx = sess.beginTransaction();
            sess.save(address);
            tx.commit();
            sess.refresh(address);
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }
}

package it.academy.load;

import it.academy.pojos.IncrementId;
import it.academy.pojos.SequenceId;
import it.academy.pojos.UuId;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class LoaderTestIdentifaer {
    public static Integer saveIncrementId(IncrementId incrementId, Session sess){

        Transaction tx = null;
        try {
            tx = sess.beginTransaction();
            sess.save(incrementId);
            tx.commit();
            sess.refresh(incrementId);
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
        return incrementId.getID();
    }

    public static Integer saveSequenceId(SequenceId sequenceId, Session sess){

        Transaction tx = null;
        try {
            tx = sess.beginTransaction();
            sess.save(sequenceId);
            tx.commit();
            sess.refresh(sequenceId);
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
        return sequenceId.getID();
    }

    public static String saveUuId(UuId uuId, Session sess){

        Transaction tx = null;
        try {
            tx = sess.beginTransaction();
            sess.save(uuId);
            tx.commit();
            sess.refresh(uuId);
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
        return uuId.getID();
    }
}

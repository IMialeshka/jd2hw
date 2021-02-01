package it.academy.load;

import it.academy.pojos.*;
import it.academy.util.HibernateUtil;
import org.hibernate.Session;

public class Load {
    public static void main(String[] args) {
        HibernateUtil hibernateUtil = new HibernateUtil();
        Session sess = hibernateUtil.getSession();
        Persons person = new Persons();
        person.setId(null);
        person.setName("Inna");
        person.setSurname("Mialeshka");
        person.setAge(35);

        int id = LoaderPerson.savePerson(person, sess);
        Persons personDell = LoaderPerson.getPerson(id, sess);
        if(personDell != null){
            LoaderPerson.dellPerson(personDell, sess);
        }
        Address address = new Address(null, "Minsk", "Central", 1, 0,
                new DescribeAddress(3, 60.0));
        LoaderAddress.saveAddress(address, sess);
        System.out.println("Increment = " +  LoaderTestIdentifaer.saveIncrementId(new IncrementId(), sess));
        System.out.println("Sequence = " +  LoaderTestIdentifaer.saveSequenceId(new SequenceId(), sess));
        System.out.println("UUID = " +  LoaderTestIdentifaer.saveUuId(new UuId(), sess));
        hibernateUtil.closeSession();
    }
}

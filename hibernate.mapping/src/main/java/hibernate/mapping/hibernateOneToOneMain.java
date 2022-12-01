package hibernate.mapping;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Date;

public class hibernateOneToOneMain {
    public static void main(String[] args) {
        org.hibernate.cfg.Configuration configuration = new Configuration();
        configuration.configure("hibernateOneToOne.cfg.xml");
        System.out.println("Hibernate Annotation Configuration loaded");
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        System.out.println("Hibernate Annotation serviceRegistry created");
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        Session session = sessionFactory.openSession();
         System.out.println("Session opened");
         Txn tx=new Txn();
         tx.setAmount(1000);
         tx.setDate(new Date());

         customer cs=new customer();
         cs.setName("Rani");
         cs.setEmail("me_ra@gmail.com");
         cs.setTxn(tx);
         tx.setCustomer(cs);//stmr(cs);

        Transaction t=session.beginTransaction();
        session.save(tx);
        t.commit();
        session.close();

        System.out.println("transaction saved successfully"+tx.getId());
    }
}

package edu.mum.cs.cs544.exercises;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

public class App {
    private static final SessionFactory sessionFactory;
    private static final ServiceRegistry serviceRegistry;

    static {
        Configuration configuration = new Configuration();
        configuration.configure();
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    public static void main(String [] args){
        //hibernate
        Session session = null;
        Transaction tx = null;

        try{
            session = sessionFactory.openSession();
            tx = session.beginTransaction();


            //creating cars
            Owner owner1 = new Owner("Andrew Walugembe","1000 4th North Street");
            Owner owner2 = new Owner("Nurlan Kustutinov","1000 4th North Street");

            Car c1 = new Car("Tesla model X","2020",3500d);
            Car c2 = new Car("Escalede","2020",4500d);

            c1.setOwner(owner1);
            c2.setOwner(owner2);

            session.persist(c1);
            session.persist(c2);

            //retrieve
            List<Car> cars = (List<Car>) session.createQuery("from Car").list();

            cars.stream().forEach(c -> System.out.println(c.getOwner()));

            tx.commit();
        }catch(HibernateException e){
            tx.rollback();
            e.printStackTrace();
        }finally{
            if(session != null){
                session.close();
            }
        }

    }
}

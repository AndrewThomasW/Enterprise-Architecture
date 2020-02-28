package edu.mum.cs.cs544.exercises.mainApplication;

import edu.mum.cs.cs544.exercises.B.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;

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

    public static void main(String[] args) {

        //hibernate placeholders
        Session session = null;
        Transaction tx = null;

        try{
            session  = sessionFactory.openSession();
            tx = session.beginTransaction();


            DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.US);

            //create customer

            Product p1 = new Product("Coffee Maker", "Black + Decker");
            Product p2 = new Product("Rice Cooker", "Aroma Rice Cooker");
            Product p3 = new Product("Body Lotion", "Vaseline BlueSeal");


            OrderLine orderLine1 = new OrderLine(30,p1);
            OrderLine orderLine2 = new OrderLine(20,p2);
            OrderLine orderLine3 = new OrderLine(20,p3);


            Order order1 = new Order(1,df.parse("03/18/2000"));
            order1.addOrderLine(orderLine1);
            order1.addOrderLine(orderLine2);
            order1.addOrderLine(orderLine3);

            Customer c1 = new Customer("Andrew","Thomas");
            c1.addOrder(order1);

            session.persist(c1);

            List<Product> products = session.createQuery("from Product").list();
            products.stream().forEach(p -> System.out.println(p));



            tx.commit();
        }catch(HibernateException | ParseException e){
            tx.rollback();
            e.printStackTrace();
        }finally{
            if(session != null) {
                session.close();}
        }
    }
    }

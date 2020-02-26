package edu.mum.cs.cs544.exercises;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.text.DateFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class AppBook {
    private static final SessionFactory sessionFactory;
    private static final ServiceRegistry serviceRegistry;

    static {
        Configuration configuration = new Configuration();
        configuration.configure();
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    public static void main(String[] args){

        //hibernate placeholders
        Session session = null;
        Transaction tx = null;

        try{
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.US);

            //create book1
            Book book1 = new Book("Things Fall Apart","001","Chinua Achebe",1000d, df.parse("04/17/2006"));
            //create book2
            Book book2 = new Book("Fairy tales","002","Hans Christian Andersen",2000d, df.parse("03/18/2000"));
            //create book3
            Book book3 = new Book("The Epic Of Gilgameshs","003","Unknown",3000d, df.parse("03/10/1998"));
            session.persist(book1);
            session.persist(book2);
            session.persist(book3);
            tx.commit();

        }catch(HibernateException | ParseException e){
            tx.rollback();
            e.printStackTrace();
        }finally{
            if(session != null) session.close();
        }


        try{
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            List<Book> books = session.createQuery("from Book").list();
            books.stream().forEach(b -> System.out.println(b));
            tx.commit();
        }catch(HibernateException e){
            tx.rollback();
            e.printStackTrace();
        }finally{
            if(session != null){
                session.close();
            }
        }


            try{
                session = sessionFactory.openSession();
                tx = session.beginTransaction();

                Book b1 = (Book)session.get(Book.class,1);
                b1.setTitle("Pride and Prejudice");
                b1.setPrice(7000d);
                session.update(b1);

                tx.commit();

            }catch(HibernateException e){
                tx.rollback();
                e.printStackTrace();
            }finally{
                if(session != null){
                    session.close();
                }
            }

        try{
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            Book b3 = (Book)session.load(Book.class,3);
            session.delete(b3);
            tx.commit();
        }catch(HibernateException e){
            tx.rollback();
            e.printStackTrace();
        }finally{
            if(session != null){
                session.close();
            }
        }




        try{
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            List<Book> books = session.createQuery("from Book").list();
            books.stream().forEach(b -> System.out.println(b));
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


package edu.mum.cs.cs544.exercises.mainApplication;

import edu.mum.cs.cs544.exercises.A.Employee;
import edu.mum.cs.cs544.exercises.A.Laptop;
import edu.mum.cs.cs544.exercises.B.Flight;
import edu.mum.cs.cs544.exercises.B.Passenger;
import edu.mum.cs.cs544.exercises.C.School;
import edu.mum.cs.cs544.exercises.C.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.*;

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


            /*Employee e1 = new Employee();
            e1.setFirstname("Andrew");
            e1.setLastname("Walugembe");

            Set<Laptop> laps = new HashSet<>();
            laps.add(new Laptop("acer","acer brand"));

            e1.setLaptops(laps);

            session.persist(e1);*/

            /*DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.US);

            Passenger p1 = new Passenger();
            p1.setName("Ugandan Passenger");
            p1.setFlights(Arrays.asList(new Flight("001","entebbe","brussels",df.parse("04/17/2006"))));

            Passenger p2 = new Passenger();
            p2.setName("jim Katunga");
            p2.setFlights(Arrays.asList(
                    new Flight("002","chicago","cedar rapids",df.parse("04/17/2020")),
                    new Flight("003","fairfield","texas",df.parse("04/17/2019")),
                    new Flight("004","entebbe","nairobi",df.parse("04/17/2015"))
            ));


            session.persist(p1);
            session.persist((p2));*/


            Student student1 = new Student(1,"Jim","Katunguka");
            Student student2 = new Student(2,"Jirom","Mebrahtu");
            Student student3 = new Student(3,"James","Igaba");


            School s1 = new School("Maharishi School",student1);

            s1.addStudent(student2);
            s1.addStudent(student3);

            session.persist(s1);

            tx.commit();
        }catch(HibernateException e){
            tx.rollback();
            e.printStackTrace();
        }finally{
            if(session != null) {
                session.close();}
        }
    }
    }

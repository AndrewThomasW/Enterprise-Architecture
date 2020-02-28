package edu.mum.cs.cs544.exercises.mainApplication;

import edu.mum.cs.cs544.exercises.A.Department;
import edu.mum.cs.cs544.exercises.A.Employee;
import edu.mum.cs.cs544.exercises.A.Office;
import edu.mum.cs.cs544.exercises.B.Book;
import edu.mum.cs.cs544.exercises.C.Student;
import edu.mum.cs.cs544.exercises.D.Customer;
import edu.mum.cs.cs544.exercises.D.Reservation;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Arrays;
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

//            Employee emp = new Employee(new Department("Computer Science"),"001","Andrew");
//            session.persist(emp);
//
//
//            Book book1 = new Book();
//            Book book2 = new Book();
//
//            session.persist(book1);
//            session.persist((book2));
//
//            Student s1 = new Student();
//            s1.setFirstname("Andrew");
//            s1.setLastname("Thomas");
//            session.persist(s1);
//
            DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.US);
            Book b1 = new Book();
            b1.setAuthor("Chinua Achebe");
            b1.setIsbn("011");

            Reservation r1 = new Reservation();
            r1.setDate( df.parse("03/10/1998"));
            r1.setBook(b1);

            Customer c1 = new Customer();
            c1.setName("Andrew Thomas Walugembe");
            c1.setReservations(Arrays.asList(r1));

            session.persist(c1);

            Employee employee = new Employee();
            employee.setName("Andrew Thomas Walugembe");
            employee.setEmployeeNumber("610541");
            employee.setOffice(new Office("217","141"));
            employee.setDepartment(new Department("Computer Science"));

            session.persist(employee);


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

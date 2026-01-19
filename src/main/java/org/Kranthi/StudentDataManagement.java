package org.Kranthi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

class HibernateUtil {

    private static final SessionFactory SESSION_FACTORY = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {


            Configuration cfg = new Configuration();
            cfg.configure();
            cfg.addAnnotatedClass(Student.class);

            return cfg.buildSessionFactory();


    }

    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }
}


public class StudentDataManagement {
    public void  addStudent(Student student){
        Student currentStudent = student;


        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();

        session.persist(student);

        transaction.commit();

        session.close();


    }
}

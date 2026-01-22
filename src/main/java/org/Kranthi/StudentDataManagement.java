package org.Kranthi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class StudentDataManagement {
    public void  addStudentToDataBase(Student student){
        Student currentStudent = student;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(student);
        transaction.commit();
        session.close();

    }

    public void deleteStudentFromDataBase(String id){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session  session = sessionFactory.openSession();

        Student student = new Student();
        student = getStudentFromDataBase(id);

        if(student == null){
            session.close();

            return;
        }
        session.remove(student);
        session.close();

    }

    public Student getStudentFromDataBase(String id){

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session  session = sessionFactory.openSession();

        Student student = new Student();
        student = session.find(Student.class,id);

        session.close();
        return student;


    }

    public Student updateStudentInDataBase(Student student){
        Student updatedStudent = student;

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();


        session.merge(updatedStudent);

        transaction.commit();

        session.close();
        return updatedStudent;


    }

}

package org.Kranthi;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class CoursesDataManagement {

    public void addCourseToDataBase(Course course){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        // Adding course to the data Base
        session.persist(course);

        transaction.commit();
        session.close();

        return;

    }

    public Course getCourseFromDataBase(String courseId){
        Session session = HibernateUtil.getSessionFactory().openSession();

        Course course = session.find(Course.class,courseId);

        session.close();

        return course;
    }

    public Course deleteCourseFromDataBase(String courseId){
        Course course = getCourseFromDataBase(courseId);

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.remove(course);
        transaction.commit();
        session.close();
        return course;


    }

    public void  updateCourseInDataBase(Course course){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.merge(course);

        session.close();

    }
}

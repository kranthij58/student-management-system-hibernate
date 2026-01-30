package org.Kranthi;

import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class CourseDetailsCollection {

    public static String getCourseIdFromUser(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter course Id : ");
        String courseId = scan.next();
        return courseId;
    }

    public static String getCourseNameFromUser(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter course Name : ");
        String  courseName = scan.next();
        return courseName;
    }

    public static int getCourseCostFromUser(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter course Cost : ");
        int courseCost= scan.nextInt();
        return courseCost;
    }

    public static List<String> getCourseTechnologiesFromUser(){
        Scanner scan = new Scanner(System.in);
        List<String> courseTechnologies = new ArrayList<>();

        System.out.println("Enter no of technolgies the course have : ");
        int limit = scan.nextInt();
        for(int i = 1 ; i<=limit; i++){
            System.out.println("Enter Technology "+i);

            String temp = scan.next();
            courseTechnologies.add(temp);
        }

        return courseTechnologies;
    }
}

public class CourseManager {

    public Course getCourse(){

        CoursesDataManagement coursesDataManagement = new CoursesDataManagement();
        String courseId = CourseDetailsCollection.getCourseIdFromUser();
        Course course = coursesDataManagement.getCourseFromDataBase(courseId);
        if(course == null){
            System.out.println(" There is no course with this ID : ");

        }
        System.out.println(course);
        return course;

    }

    public void addCouse(){


        String courseId = CourseDetailsCollection.getCourseIdFromUser();
        CoursesDataManagement coursesDataManagement = new CoursesDataManagement();

        Course course = new Course();
        Course checkCourse = coursesDataManagement.getCourseFromDataBase(courseId);
        if(checkCourse!= null){
            System.out.println("Couse Alreay exists with this id : ");
            System.out.println(course);
            return;
        }

        course.setCourseId(courseId);
        course.setCourseName(CourseDetailsCollection.getCourseNameFromUser());
        course.setCourseCost(CourseDetailsCollection.getCourseCostFromUser());
        course.setTechologiesProvided(CourseDetailsCollection.getCourseTechnologiesFromUser());

        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();
        session.persist(course);
        transaction.commit();
        session.close();
        System.out.println("Course Added to Database : "+course);


    }

    public void deleteCourse(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();


        CoursesDataManagement coursesDataManagement = new CoursesDataManagement();
        String courseId = CourseDetailsCollection.getCourseIdFromUser();
        Course course = coursesDataManagement.getCourseFromDataBase(courseId);
        if(course == null){
            return;
        }
        session.remove(course);

        System.out.println("Deleted Course : " + course);


        transaction.commit();
        session.close();

    }

    public void updateCourse(){

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        System.out.println("Enter course details for updating : ");
        String courseId = CourseDetailsCollection.getCourseIdFromUser();
        CoursesDataManagement coursesDataManagement = new CoursesDataManagement();

        Course course = coursesDataManagement.getCourseFromDataBase(courseId);
        if(course == null){
            Scanner scan = new Scanner(System.in);
            System.out.println("Course Doesnt exists Do you want to add : Yes or No");
            boolean continues = scan.next().toLowerCase().trim().equals("yes");
            if(!continues){
                return;
            }
        }
        Course updatedCourse = new Course();
        updatedCourse.setCourseId(CourseDetailsCollection.getCourseIdFromUser());
        updatedCourse.setCourseName(CourseDetailsCollection.getCourseNameFromUser());
        updatedCourse.setCourseCost(CourseDetailsCollection.getCourseCostFromUser());
        updatedCourse.setTechologiesProvided(CourseDetailsCollection.getCourseTechnologiesFromUser());

        session.merge(updatedCourse);
        transaction.commit();

        System.out.println("udpated course : " + updatedCourse);

        session.close();


    }
}

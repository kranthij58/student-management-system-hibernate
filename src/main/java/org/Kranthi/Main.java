package org.Kranthi;

import java.util.*;


public class Main{
    public static void main(String[] args) {

        CourseManager courseManager = new CourseManager();
        StudentManager studentManager = new StudentManager();


        courseManager.addCouse();


        courseManager.getCourse();


        boolean hasAdded = studentManager.newStudent();
        if (hasAdded) {
            System.out.println("Student has been registered");
        } else {
            System.out.println("Please try again later");
        }


        studentManager.getStudent();
    }
}






package org.Kranthi;

import java.util.Scanner;

public class StudentManager {


    public boolean newStudent(){
        String name;
        String roll;
        int age;
        int marks;
        String course;

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter name : ");
        name = scan.next();
        System.out.println("Enter RollNo : ");
        roll = scan.next();
        System.out.println("Enter age : ");
        age = scan.nextInt();
        System.out.println("Enter marks : ");
        marks = scan.nextInt();
        System.out.println("Enter course : ");
        course = scan.next();

        Student s1 = new Student();
        s1.setsName(name);
        s1.setsRoll(roll);
        s1.setsMarks(marks);
        s1.setsAge(age);
        s1.setsCourse(course);


        StudentDataManagement studentDataManagement = new StudentDataManagement();

        studentDataManagement.addStudent(s1);
        return true;
    }
}

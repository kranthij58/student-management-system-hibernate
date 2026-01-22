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

        studentDataManagement.addStudentToDataBase(s1);
        return true;
    }

    public void removeStudent(){
        System.out.println("Enter Student Id : ");
        Scanner scan = new Scanner(System.in);
        String studentId = scan.next();
        studentId = studentId.trim();
        Student student = new Student();

        StudentDataManagement studentDataManagement = new StudentDataManagement();
        student = studentDataManagement.getStudentFromDataBase(studentId);
        studentDataManagement.deleteStudentFromDataBase(studentId);


        if(student == null){
            System.out.println("No sudent available ");
            return;
        }
        System.out.println("Student Remvoved : " + student);
    }

    public Student  getStudent(){
        System.out.println("Enter student Id : ");
        Scanner scan = new Scanner(System.in);
        String id = scan.next();
        id = id.trim();

        StudentDataManagement studentDataManagement = new StudentDataManagement();
        Student student = new Student();
        student = studentDataManagement.getStudentFromDataBase(id);
        if(student == null){
            System.out.println("No Student Available with id : " + id);
            return null;
        }

        System.out.println(student);
        return student;
    }

    public void updateStudent(){

        Student student = getStudent();
        if(student == null){
            System.out.println("Student does not present try again with correct id ");
            return;
        }

        Scanner scan = new Scanner(System.in);
        System.out.println( "Enter updated details : ");
        System.out.println("Name: ");
        String name = scan.next();
        System.out.println("Course: ");
        String course = scan.next();
        System.out.println("Age: ");
        int age = scan.nextInt();
        System.out.println("Marks: ");
        int marks = scan.nextInt();

        student.setsName(name);
        student.setsAge(age);
        student.setsMarks(marks);
        student.setsCourse(course);

        StudentDataManagement studentDataManagement = new StudentDataManagement();
        studentDataManagement.updateStudentInDataBase(student);

        System.out.println("Updated Student : " + student);






    }
}

package org.Kranthi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class StudentsDetailsCollection {

    public static String getStudentIdFromUser(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter student Id : ");
        String studentId = scan.next();
        return studentId;
    }

    public static String getStudentNameFromUser(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter student Name : ");
        String  studentName = scan.next();
        return studentName;
    }

    public static int getStudentAgeFromUser(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter student age : ");
        int studentAge= scan.nextInt();
        return studentAge;
    }

    public static int getStudentMarksFromUser(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter student marks : ");
        int studentMarks= scan.nextInt();
        return studentMarks;
    }




}

public class StudentManager {


    public boolean newStudent(){
        String name;
        String roll;
        int age;
        int marks;



        name = StudentsDetailsCollection.getStudentNameFromUser();

        roll = StudentsDetailsCollection.getStudentIdFromUser();

        age = StudentsDetailsCollection.getStudentAgeFromUser();

        marks = StudentsDetailsCollection.getStudentMarksFromUser();

        CoursesDataManagement cdm = new CoursesDataManagement();

        Course java = cdm.getCourseFromDataBase("C101");
        Course spring = cdm.getCourseFromDataBase("C102");


        List<Course> courseList = new ArrayList<>();
        courseList.add(java);
        courseList.add(spring);

        Student s1 = new Student();
        s1.setsName(name);
        s1.setsRoll(roll);
        s1.setsMarks(marks);
        s1.setsAge(age);
        s1.setCourses(courseList);





        StudentDataManagement studentDataManagement = new StudentDataManagement();

        studentDataManagement.addStudentToDataBase(s1);
        return true;
    }

    public void removeStudent(){

        String studentId =StudentsDetailsCollection.getStudentIdFromUser();
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

        String id = StudentsDetailsCollection.getStudentIdFromUser();
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


        System.out.println( "Enter updated details : ");

        String name = StudentsDetailsCollection.getStudentNameFromUser();


        int age = StudentsDetailsCollection.getStudentAgeFromUser();

        int marks = StudentsDetailsCollection.getStudentAgeFromUser();

        student.setsName(name);
        student.setsAge(age);
        student.setsMarks(marks);



        CoursesDataManagement cdm = new CoursesDataManagement();

        Course java = cdm.getCourseFromDataBase("C101");
        Course spring = cdm.getCourseFromDataBase("C102");

        List<Course> updatedCourses = new ArrayList<>();
        updatedCourses.add(java);
        updatedCourses.add(spring);


        student.setsName(name);
        student.setsAge(age);
        student.setsMarks(marks);
        student.setCourses(updatedCourses);





        StudentDataManagement sdm = new StudentDataManagement();
        sdm.updateStudentInDataBase(student);

        System.out.println("Updated Student : " + student);


        StudentDataManagement studentDataManagement = new StudentDataManagement();
        studentDataManagement.updateStudentInDataBase(student);

        System.out.println("Updated Student : " + student);






    }
}

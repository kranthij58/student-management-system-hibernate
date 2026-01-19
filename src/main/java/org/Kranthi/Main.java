package org.Kranthi;

import java.util.*;


public class Main{
    public static void main(String[] args) {

        StudentManager studentManager = new StudentManager();
        boolean hasAddedd = studentManager.newStudent();
        if(hasAddedd){
            System.out.println("Student Has been Registered");
        }else{
            System.out.println("Please try again later");
        }
    }
}






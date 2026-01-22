package org.Kranthi;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity

public class Course {
    @Id
    String courseId;
    String courseName;
    int courseCost;
    List<String>  techologiesProvided;

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseCost() {
        return courseCost;
    }

    public void setCourseCost(int courseCost) {
        this.courseCost = courseCost;
    }

    public List<String> getTechologiesProvided() {
        return techologiesProvided;
    }

    public void setTechologiesProvided(List<String> techologiesProvided) {
        this.techologiesProvided = techologiesProvided;
    }
//    @ManyToMany
//    List<Student> students;


    @Override
    public String toString() {
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", courseCost=" + courseCost +
                ", techologiesProvided=" + techologiesProvided +
                '}';
    }
}

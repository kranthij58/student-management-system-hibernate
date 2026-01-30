package org.Kranthi;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    String courseId;
    String courseName;
    int courseCost;
    List<String>  techologiesProvided;

    @ManyToMany(mappedBy = "courses")
    List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

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



   // @Override
//    public String toString() {
//        return "Course{" +
//                "courseId='" + courseId + '\'' +
//                ", courseName='" + courseName + '\'' +
//                ", courseCost=" + courseCost +
//                ", techologiesProvided=" + techologiesProvided +
//                '}';
//    }
}

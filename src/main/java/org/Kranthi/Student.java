package org.Kranthi;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "StudentTable")

public class Student {
    @Column(nullable = false)
    private String sName;
    @Id
    private String sRoll;
    private int sAge;
    private int sMarks;

    @ManyToMany
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )

    List<Course> courses;


    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }



    public String getsName() {
        return sName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sName='" + sName + '\'' +
                ", sRoll='" + sRoll + '\'' +
                ", sAge=" + sAge +
                ", sMarks=" + sMarks +
                '}';
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsRoll() {
        return sRoll;
    }

    public void setsRoll(String sRoll) {
        this.sRoll = sRoll;
    }

    public int getsAge() {
        return sAge;
    }

    public void setsAge(int sAge) {
        this.sAge = sAge;
    }



    public int getsMarks() {
        return sMarks;
    }

    public void setsMarks(int sMarks) {
        this.sMarks = sMarks;
    }
}

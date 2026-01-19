package org.Kranthi;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "StudentTable")

public class Student {
    @Column(nullable = false)
    private String sName;
    @Id
    private String sRoll;
    private int sAge;
    private String sCourse;
    private int sMarks;


    public String getsName() {
        return sName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sName='" + sName + '\'' +
                ", sRoll='" + sRoll + '\'' +
                ", sAge=" + sAge +
                ", sCourse=" + sCourse +
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

    public String getsCourse() {
        return sCourse;
    }

    public void setsCourse(String sCourse) {
        this.sCourse = sCourse;
    }

    public int getsMarks() {
        return sMarks;
    }

    public void setsMarks(int sMarks) {
        this.sMarks = sMarks;
    }
}

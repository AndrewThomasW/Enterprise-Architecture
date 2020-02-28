package edu.mum.cs.cs544.exercises.C;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
public class Student {

    //fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Integer studentId;//

    private String firstName;
    private String lastName;

    public Student(){

    }

    public Student(Integer studentId, String fistName, String lastName) {
        this.studentId = studentId;
        this.firstName = fistName;
        this.lastName = lastName;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getFistName() {
        return firstName;
    }

    public void setFistName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

package edu.mum.cs.cs544.exercises.C;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String studentid;
    public String firstname;
    public String lastname;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Student_Course",
        joinColumns = { @JoinColumn(name = "student_id")},
        inverseJoinColumns ={ @JoinColumn (name = "course_id")}
    )
    private List<Course> courses;

    public Student(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}

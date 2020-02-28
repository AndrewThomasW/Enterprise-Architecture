package edu.mum.cs.cs544.exercises.C;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;
@Entity
public class School {
    //fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "school_id")
    @MapKey(name = "studentId")
    Map<Integer,Student> students;

    public School(){

    }

    public School(String name, Student student){
        this.name = name;
        students = new HashMap<>();
        addStudent(student);
    }

    public void addStudent(Student student){
        students.put(student.getStudentId(),student);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Integer, Student> getStudents() {
        return students;
    }

    public void setStudents(Map<Integer, Student> students) {
        this.students = students;
    }
}

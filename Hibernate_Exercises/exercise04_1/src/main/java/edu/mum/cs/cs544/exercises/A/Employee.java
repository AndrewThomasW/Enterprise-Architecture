package edu.mum.cs.cs544.exercises.A;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstname;
    private String lastname;

    @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
    private Set<Laptop> laptops;



    //constructors
    public Employee(){

    }

    public Employee(String firstname,String lastname, Laptop laptop){
        this.firstname = firstname;
        this.lastname = lastname;
        laptops = new HashSet<>();
        laptops.add(laptop);
    }

    //getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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


    public void addLaptop(Laptop laptop){
        laptops.add(laptop);
    }

    public Set<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(Set<Laptop> laptops) {
        this.laptops = laptops;
    }
}

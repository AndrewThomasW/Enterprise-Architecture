package edu.mum.cs.cs544.exercises.A;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Laptop {
    //fields
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    private String brand;
    private String type;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    //constructor
    public Laptop(){

    }

    public Laptop(String brand, String type) {
        this.brand = brand;
        this.type = type;
    }

    //methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Laptop laptop = (Laptop) o;
        return id == laptop.id &&
                Objects.equals(brand, laptop.brand) &&
                Objects.equals(type, laptop.type) &&
                Objects.equals(employee, laptop.employee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand, type, employee);
    }
}

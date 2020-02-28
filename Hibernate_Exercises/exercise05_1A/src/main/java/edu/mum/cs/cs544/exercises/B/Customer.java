package edu.mum.cs.cs544.exercises.B;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {
    //fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;

    private String firstName;
    private String lastName;

    @OneToMany(cascade = CascadeType.PERSIST)
    @OrderColumn(name = "sequence")
    @JoinColumn(name= "customer_id")
    private List<Order> orders;

    //constructor
    public Customer(){

    }

    public Customer(String firstName,String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        orders = new ArrayList<>();
    }

    //methods

    public void addOrder(Order order){
        orders.add(order);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}

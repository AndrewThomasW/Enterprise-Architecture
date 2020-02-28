package edu.mum.cs.cs544.exercises.B;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Table(name = "OrderTable")
@Entity
public class Order {
    //fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    private int orderId;
    @Temporal(TemporalType.DATE)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "customer_id", updatable = false,insertable = false)
    private Customer customer;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "order_id")
    @OrderColumn(name = "sequence")
    private List<OrderLine> orderlines;

    //constructor
    public Order(){

    }

    public Order(int orderId, Date date) {
        this.orderId = orderId;
        this.date = date;
        orderlines = new ArrayList<>();
    }

    public void addOrderLine(OrderLine orderLine){
        orderlines.add(orderLine);
    }

    public List<OrderLine> getOrderlines() {
        return orderlines;
    }

    public void setOrderlines(List<OrderLine> orderlines) {
        this.orderlines = orderlines;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}

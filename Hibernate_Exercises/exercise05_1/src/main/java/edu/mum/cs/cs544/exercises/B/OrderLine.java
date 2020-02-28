package edu.mum.cs.cs544.exercises.B;

import javax.persistence.*;

@Entity
public class OrderLine {
    //fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Integer quantity;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinTable(name ="orderLine_Product")
    private Product product;

    public OrderLine() {
    }

    public OrderLine(Integer quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}

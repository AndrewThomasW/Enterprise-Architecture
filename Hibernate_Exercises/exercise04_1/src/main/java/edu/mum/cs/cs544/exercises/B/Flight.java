package edu.mum.cs.cs544.exercises.B;

import javax.persistence.*;
import java.util.Date;
@Entity
public class Flight {
    //fields

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String flightNumber;
    @Column(name = "[from]")
    private String from;
    @Column(name = "[to]")
    private  String to;

    @Temporal(TemporalType.DATE)
    private Date date;

    public Flight(){

    }

    public Flight(String flightNumber,String from,String to,Date date){
        this.flightNumber = flightNumber;
        this.from = from;
        this.to = to;
        this.date = date;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

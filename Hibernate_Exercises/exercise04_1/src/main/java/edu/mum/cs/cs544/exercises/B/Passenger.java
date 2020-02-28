package edu.mum.cs.cs544.exercises.B;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Passenger {
    //fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "passenger_id")
    @OrderColumn(name = "sequence")
    private List<Flight> flights;

    public Passenger(){

    }

    public Passenger(String name,Flight flight){
        this.name = name;
        flights = new LinkedList<>();
        flights.add(flight);
    }

    public void addFlight(Flight flight){
        flights.add(flight);
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

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }
}

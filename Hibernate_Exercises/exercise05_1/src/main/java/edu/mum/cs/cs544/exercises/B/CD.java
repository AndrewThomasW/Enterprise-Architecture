package edu.mum.cs.cs544.exercises.B;

import javax.persistence.Entity;

@Entity
public class CD extends Product {

    //fields
    private String artist;

    public CD(){

    }

    public CD(String name, String description, String artist) {
        super(name, description);
        this.artist = artist;
    }

    //methods
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "CD{" +
                "artist='" + artist + '\'' +
                '}';
    }
}

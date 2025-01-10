package com.org.simuladorformula1.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.ArrayList;
import java.util.List;

@Entity
public class GP {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String country;
    private String track;

    @Min(35)
    @Max(100)
    private int laps;
    private List<String> classification = new ArrayList<>(20);
    private ArrayList raceClassification;
    private Pilot bestLap;
    private Pilot winner;

    // Constructors
    public GP() {}
    public GP(String country, String track, int laps) {
        this.country = country;
        this.track = track;
        this.laps = laps;
    }

    //Getters and Setters
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }

    public int getLaps() {
        return laps;
    }

    public void setLaps(int laps) {
        this.laps = laps;
    }

    public ArrayList getClassification() {
        return classification;
    }

    public void setClassification(ArrayList classification) {
        this.classification = classification;
    }

    public ArrayList getRaceClassification() {
        return raceClassification;
    }

    public void setRaceClassification(ArrayList raceClassification) {
        this.raceClassification = raceClassification;
    }

    public Pilot getBestLap() {
        return bestLap;
    }

    public void setBestLap(Pilot bestLap) {
        this.bestLap = bestLap;
    }

    public Pilot getWinner() {
        return winner;
    }

    public void setWinner(Pilot winner) {
        this.winner = winner;
    }
}

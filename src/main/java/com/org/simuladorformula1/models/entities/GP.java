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

    @ElementCollection
    @Column(name = "classification")
    private List<String> classification;

    @ManyToOne
    @JoinColumn(name = "pilots_in_race")
    private List<Pilot> pilots;

    @ManyToOne
    @JoinColumn(name = "pilots_classification")
    private List<Pilot> finalClassification;


    @ManyToOne
    @JoinColumn(name = "best_lap_id")
    private Pilot bestLap;

    @ManyToOne
    @JoinColumn(name = "winner_id")
    private Pilot winner;

    // Constructors
    public GP() {
        classification = new ArrayList<>(20);
    }
    public GP(String country, String track, int laps) {
        this.country = country;
        this.track = track;
        this.laps = laps;
        classification = new ArrayList<>(20);
    }

    //Getters and Setters


    public List<Pilot> getPilots() {return pilots;}

    public void setPilots(List<Pilot> pilots) {this.pilots = pilots;}

    public void setClassification(List<String> classification) {
        this.classification = classification;
    }

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

    public ArrayList getClassification() {return classification;}

    public void setClassification(ArrayList classification) {this.classification = classification;}

    public ArrayList getRaceClassification() {return raceClassification;}

    public void setRaceClassification(ArrayList raceClassification) {this.raceClassification = raceClassification;}

    public Pilot getBestLap() {return bestLap;}

    public void setBestLap(Pilot bestLap) {this.bestLap = bestLap;}

    public Pilot getWinner() {return winner;}

    public void setWinner(Pilot winner) {this.winner = winner;}
}

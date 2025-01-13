package com.org.simuladorformula1.dto;

import com.org.simuladorformula1.models.entities.Pilot;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class TeamDTO {
    private Integer id;
    private String name;
    private String car;
    private String teamPrincipal;
    private List<String> pilotNames;

    // Construtor e getters/setters
    public TeamDTO(Integer id, String name, String car, String teamPrincipal) {
        this.id = id;
        this.name = name;
        this.car = car;
        this.teamPrincipal = teamPrincipal;
        this.pilotNames = new ArrayList<>();
    }

    //Getters
    public int getId() {
        return id;
    }

    public List<String> getPilotNames() {
        return pilotNames;
    }

    public String getName() {
        return name;
    }

    public String getCar() {
        return car;
    }

    public String getTeamPrincipal() {
        return teamPrincipal;
    }


    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public void setTeamPrincipal(String teamPrincipal) {
        this.teamPrincipal = teamPrincipal;
    }

    public void setPilotNames(List<String> pilotNames) {
        this.pilotNames = pilotNames;
    }
}

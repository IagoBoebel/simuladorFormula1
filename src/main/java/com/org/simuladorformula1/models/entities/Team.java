package com.org.simuladorformula1.models.entities;

import jakarta.persistence.*;
import org.springframework.web.bind.annotation.Mapping;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private String name;
    private String car;
    private String teamPrincipal;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pilot> pilots = new ArrayList<>();

    // private List<String> sponsors = new ArrayList<>();

    public Team()  {}
    public Team(String name, String car, String teamPrincipal) {
        this.name = name;
        this.car = car;
        this.teamPrincipal = teamPrincipal;
    }


    // Getters e setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public String getTeamPrincipal() {
        return teamPrincipal;
    }

    public void setTeamPrincipal(String teamPrincipal) {
        this.teamPrincipal = teamPrincipal;
    }

    public List<Pilot> getPilots() {
        return pilots;
    }

    public void addPilot(Pilot pilot) {
        if (this.pilots.size() >= 2) {
            throw new IllegalStateException("O time já possui 2 pilotos. Não é possível adicionar mais.");
        }
        this.pilots.add(pilot);  // Adiciona o piloto à lista
        pilot.setTeam(this);     // Atualiza a relação bidirecional
    }

    public void setPilots(List<Pilot> pilots) {
        this.pilots = pilots;
    }
}

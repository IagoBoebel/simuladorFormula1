package com.org.simuladorformula1.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Pilot {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    private String name;

    // Idade
    @Min(17)
    @Max(62)
    @NotNull
    private int age;

    // Salario
    @NotNull
    private double salary;

    // Patrocinadores
    private List<String> sponsors = new ArrayList<>();
    private int championPosition;

    @ManyToOne
    @JoinColumn(name = "team_id", nullable = true)
    private Team team;

    // Construtor padrão obrigação do hibernate
    public Pilot() {}

    public Pilot(int age, String name, int height, int weight, double salary) {
        if(age < 17 || age > 62) {
            throw new IllegalArgumentException("A idade deve ser entre 17 e 62 anos");
        }
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    // Getters

    public Team getTeam() {return team;}

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

   public List<String> getSponsors() {
        return sponsors;
    }

    public int getChampionPosition() {
        return championPosition;
    }

    // Setters
    public void setTeam(Team team) { this.team = team; }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        if(age < 17 || age > 62) {
            throw new IllegalArgumentException("A idade deve ser entre 17 e 62 anos");
        }
        this.age = age;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }


    public void setSponsors(ArrayList<String> sponsors) {
        this.sponsors = sponsors;
    }


    public void setChampionPosition(int championPosition) {
        this.championPosition = championPosition;
    }


}

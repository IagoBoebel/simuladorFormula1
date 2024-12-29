package com.org.simuladorformula1.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.ArrayList;

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
    @NotBlank
    private int age;

    // Altura (cms)
    @Min(140)
    @Max(250)
    @NotBlank
    private int height;

    // Peso (kgs)
    @Min(50)
    @Max(200)
    @NotBlank
    private int weight;

    // Salario
    @NotBlank
    private int salary;

    // Patrocinadores
    private ArrayList<String> sponsors = new ArrayList<>();
    private int championPosition;
    //private Team team;

    public Pilot() {}

    public Pilot(int age, String name, int height, int weight, int salary) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.salary = salary;
        this.age = age;
    }


    // Getters

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public int getSalary() {
        return salary;
    }

    public ArrayList<String> getSponsors() {
        return sponsors;
    }

    public int getChampionPosition() {
        return championPosition;
    }

    // Setters

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setSponsors(ArrayList<String> sponsors) {
        this.sponsors = sponsors;
    }

    public void setChampionPosition(int championPosition) {
        this.championPosition = championPosition;
    }
}

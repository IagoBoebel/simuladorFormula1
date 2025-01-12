package com.org.simuladorformula1.dto;

import java.util.List;

public class PilotDTO {

    private int id;
    private String name;
    private int age;
    private double salary;
    private List<String> sponsors;
    private int championPosition;
    private String teamName; // Apenas o nome do time

    // Construtor
    public PilotDTO(int id, String name, int age, double salary, List<String> sponsors, int championPosition, String teamName) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.sponsors = sponsors;
        this.championPosition = championPosition;
        this.teamName = teamName;
    }

    // Getters e Setters
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public List<String> getSponsors() {
        return sponsors;
    }

    public void setSponsors(List<String> sponsors) {
        this.sponsors = sponsors;
    }

    public int getChampionPosition() {
        return championPosition;
    }

    public void setChampionPosition(int championPosition) {
        this.championPosition = championPosition;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}

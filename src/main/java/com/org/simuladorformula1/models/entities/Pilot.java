package com.org.simuladorformula1.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;

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

    // Altura (cms)
    @Min(140)
    @Max(250)
    @NotNull
    private int height;

    // Peso (kgs)
    @Min(50)
    @Max(200)
    @NotNull
    private int weight;

    // Salario
    @NotNull
    private int salary;

    // Patrocinadores
    private ArrayList<String> sponsors = new ArrayList<>();
    private int championPosition;
    //private Team team;

    public Pilot() {}

    public Pilot(int age, String name, int height, int weight, int salary) {
        if(age < 17 || age > 62) {
            throw new IllegalArgumentException("A idade deve ser entre 17 e 62 anos");
        } if(height < 140 || height > 250) {
            throw new IllegalArgumentException("A altura deve ser entre 140 e 250 centimetros");
        } if(weight < 50 || weight > 200) {
            throw new IllegalArgumentException("O peso deve ser entre 50 e 200 kilos");
        }
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
        if(age < 17 || age > 62) {
            throw new IllegalArgumentException("A idade deve ser entre 17 e 62 anos");
        }
        this.age = age;
    }

    public void setHeight(int height) {
        if(height < 140 || height > 250) {
            throw new IllegalArgumentException("A altura deve ser entre 140 e 250 centimetros");
        }
        this.height = height;
    }

    public void setWeight(int weight) {
        if(weight < 50 || weight > 200) {
            throw new IllegalArgumentException("O peso deve ser entre 50 e 200 kilos");
        }
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

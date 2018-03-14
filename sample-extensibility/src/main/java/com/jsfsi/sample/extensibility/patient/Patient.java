package com.jsfsi.sample.extensibility.patient;

import com.jsfsi.sample.extensibility.enums.Gender;
import com.jsfsi.sample.extensibility.people.Person;
import com.jsfsi.sample.extensibility.rest.LinkableResource;

import java.util.Date;

public class Patient extends LinkableResource {
    private String id;
    private String name;
    private String chip;
    private String specie;
    private String breed;
    private int age;
    private double weight;
    private Gender gender;
    private Person owner;
    private Date birthdate;
    private String castratade;
    private String hair;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecie() {
        return specie;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public String getChip() {
        return chip;
    }

    public void setChip(String chip) {
        this.chip = chip;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getCastratade() {
        return castratade;
    }

    public void setCastratade(String castratade) {
        this.castratade = castratade;
    }

    public String getHair() {
        return hair;
    }

    public void setHair(String hair) {
        this.hair = hair;
    }
}

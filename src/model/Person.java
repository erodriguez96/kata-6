/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author eduardo
 */
public class Person {

    private final Integer id;
    private final String name;
    private final Character gender;
    private final String birthdate;
    private final float weight;
    private final String mail;

    public Person(Integer id, String name, Character gender, String birthDate, Float weight, String mail) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthdate = birthDate;
        this.weight = weight;
        this.mail = mail;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Character getGender() {
        return gender;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public float getWeight() {
        return weight;
    }

    public String getMail() {
        return mail;
    }

}
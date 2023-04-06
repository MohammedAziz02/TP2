package com.tp2.Models;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class Person {
    private  int id;
    private String firstName;
    private String lastName;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date date_naiss;
    private String cne;

/*    private int age;*/

    public Person() {
    }

    public Person(int id,String firstName, String lastName, Date date_naiss, String cne) {
        this.id=id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.date_naiss = date_naiss;
        this.cne = cne;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date  getDate_naiss() {
        return date_naiss;
    }

    public void setDate_naiss(Date date_naiss) {
        this.date_naiss = date_naiss;
    }

    public String getCne() {
        return cne;
    }

    public void setCne(String cne) {
        this.cne = cne;
    }

    public int getId() {
        return  id;
    }
    public void  setId(int id){
        this.id=id;
    }

 /*   public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }*/

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", date_naiss='" + date_naiss + '\'' +
                ", cne='" + cne + '\'' +
                '}';
    }


}
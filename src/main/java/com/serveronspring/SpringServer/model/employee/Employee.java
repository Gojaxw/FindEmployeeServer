package com.serveronspring.SpringServer.model.employee;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {
    @Id
   // @GeneratedValue(strategy=GenerationType.IDENTITY) индексация
    private int id;
    private String name="";
    private String surname="";
    private Double coordinateX=0.0;
    private Double coordinateY=0.0;
    private String password="";
    private String mail="";
    public Double getCoordinateY() {
        return coordinateY;
    }

    public Double getCoordinateX() {
        return coordinateX;
    }




    public void setCoordinateY(Double coordinateY) {
        this.coordinateY = coordinateY;
    }

    public void setCoordinateX(Double coordinateX) {
        this.coordinateX = coordinateX;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                ", name='" + name + '\'' +
                ", id=" + id +'\''+
                ", coordinateX="+coordinateX+'\''+
                ", coordinateY="+coordinateY+'\''+
                '}';
    }

    public String getSurname() {
        return surname;
    }

    public String getPassword() {
        return password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

}

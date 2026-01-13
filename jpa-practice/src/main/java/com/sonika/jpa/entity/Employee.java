package com.sonika.jpa.entity;

import javax.persistence.*;

@Entity
@Table(name="employee")
public class Employee {
    @Id
    @GeneratedValue
    private int id;
    
    private String name;

    @OneToOne(mappedBy="employee")
    private LibraryMemberShip libraryMemberShip;

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }

    public String name(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public LibraryMemberShip getLibraryMemberShip(){
        return libraryMemberShip;
    }
    public void setLibraryMemberShip(LibraryMemberShip libraryMemberShip){
        this.libraryMemberShip=libraryMemberShip;
    }
}

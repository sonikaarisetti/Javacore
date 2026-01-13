package com.sonika.jpa.entity;

import javax.persistence.*;

@Entity
@Table(name="base_course")
@Inheritance(strategy=InheritanceType.JOINED)
public class BaseCourse {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    protected int id;
    protected String title;
    protected double fee;

    public int getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public void setString(String title){
        this.title=title;
    }

    public double getFee(){
        return fee;
    }
    public void setFee(double fee){
        this.fee=fee;
    }
}

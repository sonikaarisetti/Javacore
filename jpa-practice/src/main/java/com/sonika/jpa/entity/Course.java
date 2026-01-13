package com.sonika.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Embedded;

@Entity
@Table(name="course")
public class Course {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name="title")
    private String title;

    @Column(name="corse_fee")
    private double courseFee;

    @Embedded
    private Location location;

    public int getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title=title;
    }

    public double getCourseFee(){
        return courseFee;
    }
    public void setCourseFee(double courseFee){
        this.courseFee=courseFee;
    }

    public Location getLocation(){
        return location;
    }
    public void setLocation(Location location){
        this.location=location;
    }
}

package com.sonika.jpa.entity;

import javax.persistence.*;

@Entity
@Table(name="title")
public class Title {
    @Id
    @GeneratedValue
    private int id;

    @Column
    private String name;

    @Column
    private double price;

    @ManyToOne
    @JoinColumn(name="publisher_id")
    private Publisher publisher;

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price=price;
    }

    public Publisher getPublisher() {
        return publisher;
    }
    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
}

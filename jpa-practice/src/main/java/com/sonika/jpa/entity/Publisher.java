package com.sonika.jpa.entity;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="publisher")
public class Publisher {
    
    @Id
    @GeneratedValue
    private int id;

    private String name;

    @OneToMany(mappedBy="publisher")
    private List<Title> titles;

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

    public List<Title> getTitles() {
        return titles;
    }
    public void setTitles(List<Title> titles) {
        this.titles = titles;
    }
}

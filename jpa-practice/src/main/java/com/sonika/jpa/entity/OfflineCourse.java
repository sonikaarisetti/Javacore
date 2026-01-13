package com.sonika.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="offline_course")
public class OfflineCourse extends BaseCourse {
    private String location;

    public String getLocation(){
        return location;
    }
    public void setLocation(String location){
        this.location=location;
    }

    @Override
    public String toString(){
        return "OfflineCourse [id=" +id+ 
            ", title="+title+
            ", fee="+fee+
            ", location="+location+"]";
    }
}

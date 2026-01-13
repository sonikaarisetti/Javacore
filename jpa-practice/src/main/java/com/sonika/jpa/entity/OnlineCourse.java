package com.sonika.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="online_course")
public class OnlineCourse extends BaseCourse {
    private String platform;

    public String getPlatform(){
        return platform;
    }
    public void setPlatform(String platform){
        this.platform=platform;
    }

    @Override
    public String toString(){
        return "OnlineCourse [id=" +id+ 
            ", title="+title+
            ", fee="+fee+
            ", platform="+platform+"]";
    }
}

package com.sonika.jpa.entity;

import javax.persistence.Embeddable;
import javax.persistence.Column;

@Embeddable
public class Location {
    
    @Column(name="institute_name")
    private String instituteName;;

    @Column(name="address")
    private String address;

    @Column(name="city")
    private String city;

    public String getInstituteNmae(){
        return instituteName;
    }
    public void setInstituteName(String instituteName){
        this.instituteName=instituteName;
    }

    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address=address;
    }

    public String getCity(){
        return city;
    }
    public void setCity(String city){
        this.city=city;
    }
}

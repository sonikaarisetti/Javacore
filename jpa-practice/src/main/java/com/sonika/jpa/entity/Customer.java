package com.sonika.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
    @Id
    @Column(name="cust_email")
    private String email;

    @Column(name="cust_name")
    private String name;

    @Column(name="mobile_no")
    private String mobileNo;

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public String getMobileNo(){
        return mobileNo;
    }
    public void setMobileNo(String mobileNo){
        this.mobileNo=mobileNo;
    }
}

package com.sonika.jpa.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="library_membership")
public class LibraryMemberShip {
    @Id
    @GeneratedValue
    private int storeId;

    private String membershipType;
    private LocalDate startDate;

    @OneToOne
    @JoinColumn(name="employee_id")
    private Employee employee;

    public int getStoreId(){
        return storeId;
    }
    public void setStoreId(int storeId){
        this.storeId=storeId;
    }

    public String getMemberShipType(){
        return membershipType;
    }
    public void setMembershipType(String membershipType){
        this.membershipType=membershipType;
    }

    public LocalDate getStartDate(){
        return startDate;
    }
    public void setStartDate(LocalDate startDate){
        this.startDate=startDate;
    }

    public Employee getEmployee(){
        return employee;
    }
    public void setEmployee(Employee employee){
        this.employee=employee;
    }
}

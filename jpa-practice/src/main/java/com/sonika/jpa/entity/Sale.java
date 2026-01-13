package com.sonika.jpa.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="sales")
public class Sale {
    @Id
    @GeneratedValue
    private int id;

    private int quantity;
    private LocalDate saleDate;

    @ManyToOne
    @JoinColumn(name="prod_id")
    private Product product;

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }

    public int quantity(){
        return quantity;
    }
    public void setQuantity(int quantity){
        this.quantity=quantity;
    }

    public LocalDate getSaleDate(){
        return saleDate;
    }
    public void setSaleDate(LocalDate saleDate){
        this.saleDate=saleDate;
    }

    public Product getProduct(){
        return product;
    }
    public void setProduct(Product product){
        this.product=product;
    }
}

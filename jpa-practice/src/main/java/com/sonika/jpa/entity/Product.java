package com.sonika.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.CollectionTable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
@Table(name="product")
public class Product {
    @Id
    @Column(name="prod_id")
    private int id;

    @Column(name="prod_name")
    private String name;

    @Column(name="price")
    private double price;

    @ElementCollection
    @CollectionTable(
        name="product_features",
        joinColumns=@JoinColumn(name="prod_id")
    )
    @Column(name="feature")
    private List<String> features;

    @OneToMany(mappedBy="product")
    private List<Sale> sales;

    @OneToMany(mappedBy="product")
    private List<OrderProduct> orderProducts;

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

    public List<String> getFeatures(){
        return features;
    }
    public void setFeatures(List<String> features){
        this.features=features;
    }

    public List<Sale> getSales(){
        return sales;
    }
    public void setSales(List<Sale>sales){
        this.sales=sales;
    }

    public List<OrderProduct> getOrderProducts() {
        return orderProducts;
    }
    public void setOrderProducts(List<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }
}

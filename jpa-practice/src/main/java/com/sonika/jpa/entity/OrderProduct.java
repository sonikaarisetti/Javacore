package com.sonika.jpa.entity;

import javax.persistence.*;

@Entity
@Table(name="order_product")
public class OrderProduct {
    @Id
    @GeneratedValue
    private int id;

    private int quantity;

    @ManyToOne
    @JoinColumn(name="order_id")
    private Order order;
    
    @ManyToOne
    @JoinColumn(name="prod_id")
    private Product product;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
}

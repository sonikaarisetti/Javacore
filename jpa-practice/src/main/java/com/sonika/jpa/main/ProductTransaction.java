package com.sonika.jpa.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.sonika.jpa.entity.Product;

public class ProductTransaction {
    public static void main(String args[]){
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("jpa-practice");
        EntityManager em=emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Product p1=new Product();
            p1.setId(1);
            p1.setName("laptop");
            p1.setPrice(60000);

            Product p2=new Product();
            p2.setId(1);
            p2.setName("mobile");
            p2.setPrice(20000);

            em.persist(p1);
            em.persist(p2);

            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("transaction failed,rolled back");
        }
        finally{
            em.close();
            emf.close();
        }
    }
}

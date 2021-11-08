package com.ecommerce.modal;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "categories")
public class Category {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @JsonBackReference(value = "user")
    @ManyToOne
    private User user;

  //@JsonProperty(access = Access.WRITE_ONLY)
    @OneToMany(cascade = CascadeType.ALL ,mappedBy = "category")
    private List<Product> products;

    public Category() {
    }

    public Category(String name, User user, List<Product> products) {
        this.name = name;
        this.user = user;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProductToCategory(Product product){
        if (getProducts()==null){
            this.products=new ArrayList<>();

        }
        getProducts().add(product);
        product.setCategory(this);
    }
}

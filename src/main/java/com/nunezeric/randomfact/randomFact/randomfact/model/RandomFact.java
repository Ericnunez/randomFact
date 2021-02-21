package com.nunezeric.randomfact.randomFact.randomfact.model;

import com.nunezeric.randomfact.randomFact.randomfact.model.Category;

import javax.persistence.*;

@Entity
public class RandomFact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "text")
    private String fact;

    @Enumerated(EnumType.STRING)
    private Category category;

    public RandomFact( String fact, Category category) {
        this.fact = fact;
        this.category = category;
    }

    public RandomFact(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFact() {
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

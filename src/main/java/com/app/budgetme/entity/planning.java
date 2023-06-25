package com.app.budgetme.entity;

import jakarta.persistence.*;

@Entity
@Table(name="planning")
public class planning {

    // category, planned, month
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="category")
    private String category;

    @Column(name="planned")
    private Double planned;

    @Column(name="month")
    private String month;

    public planning(){

    }

    public planning(String category, Double planned, String month) {
        this.category = category;
        this.planned = planned;
        this.month = month;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPlanned() {
        return planned;
    }

    public void setPlanned(Double planned) {
        this.planned = planned;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    @Override
    public String toString() {
        return "planning{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", planned='" + planned + '\'' +
                ", month='" + month + '\'' +
                '}';
    }
}

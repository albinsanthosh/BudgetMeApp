package com.app.budgetme.utility;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

public class homeRes {

    private String category;
    private Double actual;
    private Double planned;
    private Double categoryBalance;
    private String month;
    public homeRes(){
    }

    public homeRes(String category, Double actual, Double planned, Double categoryBalance, String month) {
        this.category = category;
        this.actual = actual;
        this.planned = planned;
        this.categoryBalance = categoryBalance;
        this.month = month;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getActual() {
        return actual;
    }

    public void setActual(Double actual) {
        this.actual = actual;
    }

    public Double getPlanned() {
        return planned;
    }

    public void setPlanned(Double planned) {
        this.planned = planned;
    }

    public Double getCategoryBalance() {
        return categoryBalance;
    }

    public void setCategoryBalance(Double categoryBalance) {
        this.categoryBalance = categoryBalance;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    @Override
    public String toString() {
        return "homeRes{" +
                "category='" + category + '\'' +
                ", actual=" + actual +
                ", planned=" + planned +
                '}';
    }
}

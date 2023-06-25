package com.app.budgetme.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name="transaction")
public class transaction {

    // id, date, category, detail, spent, month
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @Column(name="category")
    private String category;

    @Column(name="detail")
    private String detail;

    @Column(name="spent")
    private Double spent;

    @Column(name="month")
    private String month;

    public transaction(){

    }

    public transaction(Date date, String category, String detail, Double spent, String month) {
        this.date = date;
        this.category = category;
        this.detail = detail;
        this.spent = spent;
        this.month = month;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Double getSpent() {
        return spent;
    }

    public void setSpent(Double spent) {
        this.spent = spent;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    @Override
    public String toString() {
        return "transaction{" +
                "id=" + id +
                ", date=" + date +
                ", category='" + category + '\'' +
                ", detail='" + detail + '\'' +
                ", spent=" + spent +
                ", month='" + month + '\'' +
                '}';
    }
}

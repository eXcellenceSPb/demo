package com.example.demos.model;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "coll", schema = "demo")
public class Call {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "direction")
    private String direction;

    @Column(name = "number")
    private int number;

    @Column(name = "abonent")
    private String abonent;

    @Column(name = "date")
    private Calendar date;

    @Column(name = "comment")
    private String comment;

    public Call() {
    }

    public Call(String direction, int number, String abonent, Calendar date, String comment) {
        this.direction = direction;
        this.number = number;
        this.abonent = abonent;
        this.date = date;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getAbonent() {
        return abonent;
    }

    public void setAbonent(String abonent) {
        this.abonent = abonent;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

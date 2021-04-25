package com.example.assignment_2.bussiness.model.base;

import com.example.assignment_2.data.model.LaboratoryDB;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

public class Laboratory {
    private Long id;

    private int number;
    private LocalDate date;
    private String title;
    private String topic;
    private String description;

    public Laboratory() {
    }

    public Laboratory(int number, LocalDate date, String title, String topic, String description) {
        this.number = number;
        this.date = date;
        this.title = title;
        this.topic = topic;
        this.description = description;
    }

    public Laboratory(LaboratoryDB laboratoryDB){
        this.id = laboratoryDB.getId();
        this.number = laboratoryDB.getNumber();
        this.date = laboratoryDB.getDate();
        this.title = laboratoryDB.getTitle();
        this.topic = laboratoryDB.getTopic();
        this.description = laboratoryDB.getDescription();
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

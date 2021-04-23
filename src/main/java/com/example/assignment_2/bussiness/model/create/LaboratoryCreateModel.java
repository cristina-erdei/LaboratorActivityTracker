package com.example.assignment_2.bussiness.model.create;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

public class LaboratoryCreateModel {
    private int number;
    private int year;
    private int month;
    private int day;
    private String title;
    private String topic;
    private String description;

    public LaboratoryCreateModel() {
    }

    public LaboratoryCreateModel(int number, int year, int month, int day, String title, String topic, String description) {
        this.number = number;
        this.year = year;
        this.month = month;
        this.day = day;
        this.title = title;
        this.topic = topic;
        this.description = description;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
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

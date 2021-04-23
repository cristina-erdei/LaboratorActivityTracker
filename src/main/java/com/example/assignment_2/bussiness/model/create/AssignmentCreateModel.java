package com.example.assignment_2.bussiness.model.create;

import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

public class AssignmentCreateModel {
    private Long laboratoryId;
    private String name;
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    private String description;

    public AssignmentCreateModel() {
    }

    public AssignmentCreateModel(Long laboratoryId, String name, int year, int month, int day, int hour, int minute, String description) {
        this.laboratoryId = laboratoryId;
        this.name = name;
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
        this.description = description;
    }


    public Long getLaboratoryId() {
        return laboratoryId;
    }

    public void setLaboratoryId(Long laboratoryId) {
        this.laboratoryId = laboratoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }
}

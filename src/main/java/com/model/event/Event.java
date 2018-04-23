package com.model.event;

import java.time.LocalDate;

public class Event {
    private int id ;
    private String title;
    private LocalDate startDate;
    private LocalDate endDate;
    private String beginLocation;
    private String endLocation;
    private String length;
    private String comment;
    private String status;
    private Boolean hasAccident;
    private String accidentLocation;
    private String descAccident;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getBeginLocation() {
        return beginLocation;
    }

    public void setBeginLocation(String beginLocation) {
        this.beginLocation = beginLocation;
    }

    public String getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getHasAccident() {
        return hasAccident;
    }

    public void setHasAccident(Boolean hasAccident) {
        this.hasAccident = hasAccident;
    }

    public String getAccidentLocation() {
        return accidentLocation;
    }

    public void setAccidentLocation(String accidentLocation) {
        this.accidentLocation = accidentLocation;
    }

    public String getDescAccident() {
        return descAccident;
    }

    public void setDescAccident(String descAccident) {
        this.descAccident = descAccident;
    }
}

package com.example.totalrec;

public class Events {
    private String title;
    private String time;
    private String location;
    private String description;
    private String date;

    public Events() {

    }

    public Events(String title, String time, String location, String description, String date) {
        this.title = title;
        this.time = time;
        this.location = location;
        this.description = description;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() { return date; }

    public void setDate(String date) { this.date = date; }
}

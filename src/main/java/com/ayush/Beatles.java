package com.ayush;

import java.util.Date;

public class Beatles {
    private int year;
    private String name;
    private Date date;

    @Override
    public String toString() {
        return "Beatles{" +
                "year=" + year +
                ", name='" + name + '\'' +
                ", date=" + date +
                '}';
    }

    public Beatles(int year, String name, Date date) {
        this.year = year;
        this.name = name;
        this.date = date;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

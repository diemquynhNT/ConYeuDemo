package com.example.conyeu.object;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Calendar implements Serializable {
    public int id;
    public String title,address,note,time,date;



    public Calendar(int id,String title, String address, String note, String time, String date) {
        this.title = title;
        this.address = address;
        this.note = note;
        this.time = time;
        this.date = date;
        this.id=id;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String toString(){
        return "Calendar{" + "id" + id + ", Title = " + title + '\'' + ", Address = " + address + '\'' + ", Note = " + note + '\'' + ", Time = " + time + '\'' + ", Date = " + date + '\'' +'}';
    }

}

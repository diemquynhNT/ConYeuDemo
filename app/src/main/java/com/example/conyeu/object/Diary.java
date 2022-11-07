package com.example.conyeu.object;

public class Diary {
    int id;
    private String contentdiary;
    private String title;

    public Diary(){

    }

    public Diary(String contentdiary, String title,int id) {
        this.contentdiary = contentdiary;
        this.title = title;
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContentdiary() {
        return contentdiary;
    }

    public void setContentdiary(String contentdiary) {
        this.contentdiary = contentdiary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

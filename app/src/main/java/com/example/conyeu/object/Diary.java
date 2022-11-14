package com.example.conyeu.object;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Diary implements Serializable {

    public int id;
     public String contentdiary,title, datediary;



    public Diary(int id, String title,String contentdiary,String datediary) {
        this.id=id;
        this.title = title;
        this.contentdiary = contentdiary;
        this.datediary=datediary;

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

    public String getDatediary() {
        return datediary;
    }

    public void setDatediary(String datediary) {
        this.datediary = datediary;
    }

//    public Map<String,Object> toMap()
//    {
//        HashMap<String,Object> result=new HashMap<>();
//        result.put("content",contentdiary);
//        return result;
//    }
}

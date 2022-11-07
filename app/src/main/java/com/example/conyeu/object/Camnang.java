package com.example.conyeu.object;

import java.io.Serializable;

public class Camnang implements Serializable {
        int id;
//        int image_cn;
        String titlecn;
        String contentcn;

        public Camnang(){}


    public Camnang(int id, String titlecn, String contentcn) {
        this.id = id;
        this.titlecn = titlecn;
        this.contentcn = contentcn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitlecn() {
        return titlecn;
    }

    public void setTitlecn(String titlecn) {
        this.titlecn = titlecn;
    }

    public String getContentcn() {
        return contentcn;
    }

    public void setContentcn(String contentcn) {
        this.contentcn = contentcn;
    }
}



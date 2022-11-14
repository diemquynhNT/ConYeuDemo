package com.example.conyeu.object;

import java.io.Serializable;

public class Camnang implements Serializable {
       public  int id;
       public  String titlecn,contentcn,detailcn;
       public byte [] imgcn;

        public Camnang(){}


    public Camnang(int id, String titlecn, String contentcn, String detailcn, byte[] imgcn) {
        this.id = id;
        this.titlecn = titlecn;
        this.contentcn = contentcn;
        this.detailcn = detailcn;
        this.imgcn = imgcn;
    }

    public byte[] getImgcn() {
        return imgcn;
    }

    public void setImgcn(byte[] imgcn) {
        this.imgcn = imgcn;
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

    public String getDetailcn() {
        return detailcn;
    }

    public void setDetailcn(String detailcn) {
        this.detailcn = detailcn;
    }
}



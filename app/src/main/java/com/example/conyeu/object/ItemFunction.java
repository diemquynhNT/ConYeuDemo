package com.example.conyeu.object;

public class ItemFunction {

    int id;
    int imgitem;
    String titleitem;

    public ItemFunction(int id,int imgitem, String titleitem) {
        this.id=id;
        this.imgitem = imgitem;
        this.titleitem = titleitem;
    }

    public int getImg() {
        return imgitem;
    }

    public void setImg(int img) {
        this.imgitem = img;
    }

    public String getTitleitem() {
        return titleitem;
    }

    public void setTitleitem(String titleitem) {
        this.titleitem = titleitem;
    }
}

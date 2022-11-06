package com.example.conyeu.object;

import java.io.Serializable;

public class Camnang implements Serializable {
        int id;
        int image_cn;
        String title;
        String content;
//
        public Camnang(int id, int image_cn, String title,String content) {
            this.id = id;
            this.image_cn = image_cn;
            this.title = title;
            this.content=content;
        }

    public Camnang(int id, int handbook, String cẩm_nang) {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
            return id;
        }

        public int getImage_cn() {
            return image_cn;
        }

        public String getTitle() {
            return title;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setImage_cn(int image_cn) {
            this.image_cn = image_cn;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }



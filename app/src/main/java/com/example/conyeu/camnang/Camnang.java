package com.example.conyeu.camnang;

import java.io.Serializable;

public class Camnang implements Serializable {
        int id;
        int image_cn;
        String title;
//
        public Camnang(int id, int image_cn, String title) {
            this.id = id;
            this.image_cn = image_cn;
            this.title = title;
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



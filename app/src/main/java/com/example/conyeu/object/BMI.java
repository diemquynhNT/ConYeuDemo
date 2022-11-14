package com.example.conyeu.object;

public class BMI {
    public int id,bmi,height,weight;
    public String datebmi;

    public BMI(int id, int bmi, int height, int weight, String datebmi) {
        this.id = id;
        this.bmi = bmi;
        this.height = height;
        this.weight = weight;
        this.datebmi = datebmi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBmi() {
        return bmi;
    }

    public void setBmi(int bmi) {
        this.bmi = bmi;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getDatebmi() {
        return datebmi;
    }

    public void setDatebmi(String datebmi) {
        this.datebmi = datebmi;
    }
}

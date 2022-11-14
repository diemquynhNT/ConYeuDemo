package com.example.conyeu.object;

public class BMI {
    public int id;
    public String namebbbmi,datebmi,height,weight,bmi,age;

    public BMI(int id, String namebbbmi, String datebmi, String height, String weight, String bmi,String age) {
        this.id = id;
        this.namebbbmi = namebbbmi;
        this.datebmi = datebmi;
        this.height = height;
        this.weight = weight;
        this.bmi = bmi;
        this.age=age;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamebbbmi() {
        return namebbbmi;
    }

    public void setNamebbbmi(String namebbbmi) {
        this.namebbbmi = namebbbmi;
    }

    public String getDatebmi() {
        return datebmi;
    }

    public void setDatebmi(String datebmi) {
        this.datebmi = datebmi;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getBmi() {
        return bmi;
    }

    public void setBmi(String bmi) {
        this.bmi = bmi;
    }
}

package com.example.conyeu.baby;

public class Baby {
    int id;
    String namebaby;
    String nickname;
    int heightbaby;
    int weightbaby;
    String birthday;

    public Baby(int id,String namebaby, String nickname, int heightbaby, int weightbaby, String birthday) {
        this.id=id;
        this.namebaby = namebaby;
        this.nickname = nickname;
        this.heightbaby = heightbaby;
        this.weightbaby = weightbaby;
        this.birthday = birthday;
    }
//

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamebaby() {
        return namebaby;
    }

    public String getNickname() {
        return nickname;
    }

    public int getHeightbaby() {
        return heightbaby;
    }

    public int getWeightbaby() {
        return weightbaby;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setNamebaby(String namebaby) {
        this.namebaby = namebaby;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setHeightbaby(int heightbaby) {
        this.heightbaby = heightbaby;
    }

    public void setWeightbaby(int weightbaby) {
        this.weightbaby = weightbaby;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}

package com.example.conyeu.object;

import java.io.Serializable;

public class Baby implements Serializable,Comparable<Baby>{
     public  int id;
    public String namebaby,nickname,sexbaby,periodbaby,birthday;


    public Baby(int id,String namebaby, String nickname, String sexbaby, String periodbaby, String birthday) {

        this.id=id;
        this.namebaby = namebaby;
        this.nickname = nickname;
        this.sexbaby = sexbaby;
        this.periodbaby = periodbaby;
        this.birthday = birthday;
    }

    //

    public String getSexbaby() {
        return sexbaby;
    }

    public void setSexbaby(String sexbaby) {
        this.sexbaby = sexbaby;
    }

    public String getPeriodbaby() {
        return periodbaby;
    }

    public void setPeriodbaby(String periodbaby) {
        this.periodbaby = periodbaby;
    }

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

    public String getBirthday() {
        return birthday;
    }

    public void setNamebaby(String namebaby) {
        this.namebaby = namebaby;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public int compareTo(Baby o) {
        return 0;
    }
}

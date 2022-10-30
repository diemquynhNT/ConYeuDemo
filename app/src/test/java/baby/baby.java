package baby;

public class baby {
    String namebaby;
    String nickname;
    int heightbaby;
    int weightbaby;
    String birthday;

    public baby(String namebaby, String nickname, int heightbaby, int weightbaby, String birthday) {
        this.namebaby = namebaby;
        this.nickname = nickname;
        this.heightbaby = heightbaby;
        this.weightbaby = weightbaby;
        this.birthday = birthday;
    }
//
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

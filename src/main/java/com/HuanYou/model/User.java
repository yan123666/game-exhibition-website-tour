package com.HuanYou.model;

import java.util.Date;
import java.util.List;

public class User {
    private int userID;
    private String username;
    private String password;
    private String nickname;
    private String head;
    private String gender;
    private String profile;
    private String loved;
    private String birthday;
    private List<Game> collect;

    public List<Game> getCollect() {
        return collect;
    }

    public void setCollect(List<Game> collect) {
        this.collect = collect;
    }



    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getLoved() {
        return loved;
    }

    public void setLoved(String loved) {
        this.loved = loved;
    }

    public String getBirthday() {
        return birthday;
    }

    public int collecting(String GameID){
        return 0;
    };

}

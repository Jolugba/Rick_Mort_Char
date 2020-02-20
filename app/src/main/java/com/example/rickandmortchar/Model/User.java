package com.example.rickandmortchar.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class User {
    // POJO Class
    @SerializedName("id")
    private int  userId;

    @SerializedName("name")
    private String characterName;

    @SerializedName("image")
    private  String imageUrl;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }



    //Constructors
    public User(int userId, String characterName, String imageUrl) {
        this.userId = userId;
        this.characterName = characterName;
        this.imageUrl = imageUrl;
    }


}






package com.example.android.learnrecyclerviews;


import java.io.Serializable;

public class ItsCode implements Serializable {
    private String name;
    private int imageResourceId;

    public ItsCode(String name, int imageResourceId) {
        this.name = name;
        this.imageResourceId = imageResourceId;
    }
    public String getName() {
        return name;
    }
    public int getImageResourceId() {
        return imageResourceId;
    }
}

package com.example.uytai.recyclerviewex;

/**
 * Created by uytai on 11/7/2017.
 */

public class Data {
    private int Image;
    private String Name;

    public Data(int image, String name) {
        Image = image;
        Name = name;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}

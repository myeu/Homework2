package com.example.marisayeung.homework2;

/**
 * Created by Marisa Yeung on 1/29/16.
 */

public class Animal {

    public Animal(String pictureName, String Name, String description) {

        this.pictureName = pictureName;
        this.Name = Name;
        this.description = description;
    }

    private String pictureName;
    private String Name;
    private String description;

    public String getName() {
        return Name;
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return description;
    }
}

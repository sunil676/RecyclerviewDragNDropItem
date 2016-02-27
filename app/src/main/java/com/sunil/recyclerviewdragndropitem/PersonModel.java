package com.sunil.recyclerviewdragndropitem;

/**
 * Created by sunil on 27-Feb-16.
 */
public class PersonModel {
    
    private String personName;
    private String imagePath;

    public PersonModel(String personName, String imagePath) {
        this.personName = personName;
        this.imagePath = imagePath;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}

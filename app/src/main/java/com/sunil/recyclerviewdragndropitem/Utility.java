package com.sunil.recyclerviewdragndropitem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunil on 27-Feb-16.
 */
public class Utility {

    static String [] imageurl = {"http://farm8.staticflickr.com/7452/27782542462_12e206359b_m.jpg",
            "http://farm8.staticflickr.com/7311/27782539412_1e1cece561_m.jpg",
            "http://farm8.staticflickr.com/7452/27782542462_12e206359b_m.jpg",
            "http://farm8.staticflickr.com/7326/27605634010_917553d601_m.jpg",
            "http://farm8.staticflickr.com/7452/27782542462_12e206359b_m.jpg",
            "http://farm8.staticflickr.com/7311/27782539412_1e1cece561_m.jpg",
            "http://farm8.staticflickr.com/7326/27605634010_917553d601_m.jpg",
            "http://farm8.staticflickr.com/7311/27782539412_1e1cece561_m.jpg"};

    static String names[]={"Nogoit",
            "Marshmallow",
            "Lollipop",
            "JellyBean",
            "Kitkat",
            "IcecreamSandwitch",
            "Froyo",
            "IOs"
    };

    public static List<ItemModel> getListPerson(){
        List<ItemModel> models = new ArrayList<>();
        models.add(new ItemModel( names[0], imageurl[0]));
        models.add(new ItemModel( names[1], imageurl[1]));
        models.add(new ItemModel( names[2], imageurl[2]));
        models.add(new ItemModel( names[3], imageurl[3]));
        models.add(new ItemModel( names[4], imageurl[4]));
        models.add(new ItemModel( names[5], imageurl[5]));
        models.add(new ItemModel( names[6], imageurl[6]));
        return models;
    }
}

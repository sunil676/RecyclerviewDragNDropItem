package com.sunil.recyclerviewdragndropitem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunil on 27-Feb-16.
 */
public class Utility {

    static String imageurl[]={"http://www.nollywoodaccess.com/wp-content/uploads/2013/05/bollywood-aishwarya-rai-red-sari-without-clothes-2062753630.jpg",
            "http://cdn.koimoi.com/wp-content/new-galleries/2012/12/Will-Dabanng-2-be-Salman-s-Bollywood-s-or-2012-s-highest-Box-Office-Opener.jpg",
            "http://images.indiatvnews.com/entertainmentbollywood/kareena-kapoor-bollywood.jpg",
            "http://im.rediff.com/movies/2013/jul/09bollywood-vintage-mode8.jpg",
            "http://sifetbabo.com/wp-content/uploads/2014/07/priyanka-chopra-beautiful-bollywood-actress.jpg",
            "http://alltoptens.com/wp-content/uploads/2013/12/Top-Ten-Bollywood-actresses-of-2014.jpg",
            "http://punnobhumi.com/files/uploads/2014/12/Bollywood-Actress-82.jpg",
            "http://images6.fanpop.com/image/photos/33700000/Ileana-bollywood-33771090-700-878.jpg"
    };
   static String names[]={"Aishwarya",
            "Salman",
            "Kareena",
            "Deepika",
            "Priyanka",
            "Anuska",
            "Sonakshi",
            "Eliyana"
    };

    public static List<PersonModel> getListPerson(){
        List<PersonModel> models = new ArrayList<>();
        models.add(new PersonModel( names[0], imageurl[0]));
        models.add(new PersonModel( names[1], imageurl[1]));
        models.add(new PersonModel( names[2], imageurl[2]));
        models.add(new PersonModel( names[3], imageurl[3]));
        models.add(new PersonModel( names[4], imageurl[4]));
        models.add(new PersonModel( names[5], imageurl[5]));
        models.add(new PersonModel( names[6], imageurl[6]));
        return models;
    }
}

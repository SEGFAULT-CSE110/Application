package com.example.tylerbakke.myapplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Christopher Cabreros on 03-May-16.
 * Tempoary class to read from
 */
public class Closet {

    private List<Clothing> list_clothes = new ArrayList<Clothing>();
    private int numCategories;
    //we need a way to check how many categories were added


    public void addClothing(Clothing val){
        list_clothes.add(val);
    }

    public void removeClothing(Clothing val){
        list_clothes.remove(val);
    }

    public List<Clothing> getList(){
        return list_clothes;
    }

}

package com.example.tylerbakke.myapplication;

import java.util.List;

/**
 * Created by Christopher Cabreros on 05-May-16.
 */
public class Lookbook {

    private List<Outfit> mOutfitList;
    private Closet mBelongingCloset;

    public Outfit generateOutfit(PreferenceList preferenceList){
        return null;
    }

    public Outfit generateRandomOutfit(){
        return null;
    }

    public List<Outfit> getOutfitList() {
        return mOutfitList;
    }

    public void addOutfit(Outfit out){
        mOutfitList.add(out);
    }

    public void removeOutfit(Outfit out){
        mOutfitList.remove(out);
    }
}

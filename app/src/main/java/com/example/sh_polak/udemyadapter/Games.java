package com.example.sh_polak.udemyadapter;

/**
 * Created by sh-polak on 16/08/2017.
 */

public class Games {
    public String mNameOfPlace;
    public int mZipCode;
    public String getmNameOfImage;
    public String mPopup;
    public String url;

    public Games(String startNameOfPlace,int startZipCode,String startNameOfImage,String startPopup,String url){
        this.mNameOfPlace=startNameOfPlace;
        this.mZipCode=startZipCode;
        this.getmNameOfImage=startNameOfImage;
        this.mPopup=startPopup;
        this.url=url;
    }
}

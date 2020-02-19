package com.example.rickandmortchar;

import java.util.ArrayList;

public class Data {
    public static ArrayList<Information> getData(){

        ArrayList<Information> data =new ArrayList<>();

        int[] images={
                R.drawable.birthday,
                R.drawable.smiley_logo,
                R.drawable.birthday,
                R.drawable.smiley_logo,

                R.drawable.birthday,
                R.drawable.smiley_logo,
                R.drawable.birthday,
                R.drawable.smiley_logo,

                R.drawable.birthday,
                R.drawable.smiley_logo,
                R.drawable.birthday,
                R.drawable.smiley_logo
        };
        String[] Categories={"Rick ","ESTHER ","ROSEMARY ","LOLADE ","IFEANYI ","CHINAZA ","MUYIWA ","IBUNKUN","MARYJANE",
                "BUNMI","BIMPE","FUNMILAYO",};

        for (int i=0; i<images.length;i++){
            Information current=new Information();
            current.names=Categories[i];
            current.imageid=images[i];

            data.add(current);
        }
        return data;
    }
}

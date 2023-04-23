package com.example.coach.outils;

import android.content.Context;

import java.io.FileOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/**
 * Classe qui permet de serialiser et de deserealiser les objets
 */
public class Serializer {

    /**
     * Serialisation d'un Object
     * @param filnam
     * @param objet
     * @param context
     */
    public static void serializer(String filnam, Object objet, Context context){

        try{
            FileOutputStream fil = context.openFileOutput(filnam, context.MODE_PRIVATE);

            //ObjectOutputStream


        }catch (Exception e){}
    }
}

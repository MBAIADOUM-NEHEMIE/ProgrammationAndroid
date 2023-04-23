package com.example.coach.controleur;

import com.example.coach.modele.ProfileUser;

public final class Controle {


    /**
     * Declaration et  Initialisation d'une Instance unique
     */
    private static Controle Instance = null;



    /**
     * Creation d'une variable de type Profile
     */
    private ProfileUser profil;


    /**
     *  cration du Constructeur
     */
    private Controle(){

        super();
    }



    /**
     * Creation d'un instance
     * @return une Instance
     */
    public static final Controle getInstance(){

        /**
         * test pour verifier si une instance existe déjà
         */
        if (Instance == null){
            /**
             *           creation de l'objet
             */

            Controle.Instance = new Controle();

        }
        return Controle.Instance;
    }

    /**
     * Creation du profil
     * @param poids
     * @param taille
     * @param age
     * @param sexe 1 pour homme et 0 pour femme
     */
    public  void creerProfil(Integer poids, Integer taille, Integer age, Integer sexe){

        /**
         * Creation du Profil
         */
        profil = new ProfileUser(poids, taille, age, sexe);
    }

    /**
     * Reccuperation du img de profil
     * @return img
     */
    public float getImg(){
        return profil.getImg();
    }

    /**
     * Reccuperation message de profil
     * @return le message
     */
    public String getMention(){
        return profil.getMention();
    }
}

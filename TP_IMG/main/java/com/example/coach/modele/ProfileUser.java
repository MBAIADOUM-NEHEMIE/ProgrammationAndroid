package com.example.coach.modele;

public class ProfileUser {

    /**
     *  Declaration des constantes
     */
    private static final Integer minFemme = 15; //si le poids est en-dessous de cette valeur, on dit que la Femme est Maigre
    private static final Integer maxFemme = 30; // elle est en surpoids si elle depasse.
    private static final Integer minHomme = 10; // il est Maigre si il son poids est en dessous
    private static final Integer maxHomme = 25; // il est en Surpoids si il depasse.

    /**
     * Declaration des variables
     */
    private Integer poids;
    private Integer taille;
    private Integer age;
    private Integer sex;
    private float img;
    private String mention;


    /**
     * Constructeur de base
     * @param poids
     * @param taille
     * @param age
     * @param sex
     */
    public ProfileUser(Integer poids, Integer taille, Integer age, Integer sex) {
        this.poids = poids;
        this.taille = taille;
        this.age = age;
        this.sex = sex;
        this.CalculIMG();
        this.resultatIMG();
    }

    /**
     * Les Getteurs
     * @return le poids Saisi
     */

    public Integer getPoids() {
        return poids;
    }

    /**
     *  Les Getter
     * @return la taille Saisi
     */
    public Integer getTaille() {
        return taille;
    }

    /**
     * Les Getter
     * @return l'age Saisi
     */
    public Integer getAge() {
        return age;
    }

    /**
     * Les Getter
     * @return le sexs Choisi
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * Les Getter
     * @return le Img calculé
     */
    public float getImg() {
        return img;
    }

    /**
     * Les Getter
     * @return  Le Message selon le Img obtenue
     */
    public String getMention() {
        return mention;
    }

    /**
     * Methode qui Calcule le Img du Profil
     */
    private void CalculIMG(){

        float tailleM = ((float) taille)/100;

        this.img = (float) (((1.2* poids)/(tailleM*tailleM)) + (0.23* age) - (10.83 * sex) - 5.4);
    }

    /**
     * Methode qui test le resultat du Img et le classe en fonction des parametres min et max
     */
    private void resultatIMG(){

        Integer min;
        Integer max;


        /**
         * Test
         * 0 pour une femme et 1 pour un homme
         */

        if (sex==0) {
            min = minFemme;
            max = maxFemme;
        } else {
            min = minHomme;
            max = maxHomme;
        }


        /**
         * Gestion du message à afficher
         */
        mention = "normal";

        if (img<min){
            mention = "Trop Maigre";
        }else {
            if (img>max){
                mention = "Trop de Graiss";
            }
        }
    }

}

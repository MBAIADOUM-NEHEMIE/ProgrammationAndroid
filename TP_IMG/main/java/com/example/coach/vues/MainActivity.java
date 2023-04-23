package com.example.coach.vues;

import static com.example.coach.controleur.Controle.*;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.coach.R;
import com.example.coach.controleur.Controle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Appel de la fonction initialisation et du controleur
         */
        initialisation();

    }

    /**
     * Les Variables
     */

    private EditText teditpoids;
    private EditText tedittaille;
    private EditText teditage;
    private RadioButton btnradio;
    private TextView imgText;
    private ImageView imageSelf;

    private Controle controle; // declaration du controleur
    /**
     * Initialisation des variables
     */
    private void initialisation(){

        /**
         * Reccuperation des liens avec les objet graphique
         */
        teditpoids  = (EditText)    findViewById(R.id.editTpoids);
        tedittaille = (EditText)    findViewById(R.id.editTtaille);
        teditage    = (EditText)    findViewById(R.id.editTage);
        btnradio    = (RadioButton) findViewById(R.id.btnRadioH);
        imgText     = (TextView)    findViewById(R.id.textVemoji);
        imageSelf   = (ImageView)   findViewById(R.id.imgEmoj);

        this.controle = Controle.getInstance();


        ecouterCal();
    }

    /**
     * Ecouter un événement sur le boutton Calcul
     */
    private void ecouterCal(){

        ((Button) findViewById(R.id.btnCalculer)).setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){

                //Toast.makeText(MainActivity.this, "Test réussit", Toast.LENGTH_SHORT).show();

                /**
                 * Declaration et initialisation des variables local
                 */
                Integer poids = 0;
                Integer taille = 0;
                Integer age = 0;
                Integer sexe = 0;

                try {
                poids = Integer.parseInt(teditpoids.getText().toString());
                taille = Integer.parseInt(tedittaille.getText().toString());
                age = Integer.parseInt(teditage.getText().toString());
                }catch (Exception e){};

                if (btnradio.isChecked()){

                    sexe = 1;
                }

                // Controle des données Saisi

                if (poids ==0 || taille == 0 || age == 0){

                    Toast.makeText(MainActivity.this, "Veillez renseigner tout les champs", Toast.LENGTH_SHORT).show();
                }else {

                    afficheResultat(poids, taille, age, sexe);
                }
            }
               // sexe = Integer.parseInt(btnradio.getText().toString());
        });

    }

    /**
     * Affichage de l'IMG, du Message, et de l'Image
     * @param poids
     * @param taille
     * @param age
     * @param sexe
     */
    private void afficheResultat(Integer poids, Integer taille, Integer age, Integer sexe){

        // Creation du profil et recuperation des informations

        this.controle.creerProfil(poids,taille, age, sexe);
        float img = this.controle.getImg();
        String message = this.controle.getMention();

        if (message == "normal"){
            imageSelf.setImageResource(R.drawable.sourir);
            imgText.setTextColor(Color.GREEN);
        }else {
            if (message == "Trop Maigre"){
                imageSelf.setImageResource(R.drawable.maigre);
                imgText.setTextColor(Color.RED);
            }else {
                imageSelf.setImageResource(R.drawable.grasse);
                imgText.setTextColor(Color.RED);
            }
        }

        imgText.setText(String.format("%.01f", img)+" : IMG "+message);
    }
}
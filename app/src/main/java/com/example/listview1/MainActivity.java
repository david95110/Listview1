package com.example.listview1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.listview1.controller.DaoPersonne;
import com.example.listview1.model.Personne;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final String LIST_PERSONNES="personnes";
    EditText eNom, ePrenom;
    // on va declarer un lanceur pour un appel préalablement préparé (l'intent)
    // pour declarer le processus d'excution
    // ActivityResultContract
    ActivityResultLauncher<Intent> intentActivityResultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eNom = findViewById(R.id.eNom);
        ePrenom = findViewById(R.id.ePrenom);

        intentActivityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                    // on teste que le resultat est ok
                        if (result.getResultCode() == Activity.RESULT_OK){
                           // on recupere l'intent que l'on a créé dans listview
                            Intent data = result.getData()  ;

                            // on recupere la personne stockée
                            Personne personne = (Personne) data.getSerializableExtra(ListViewActivity.PERSONNE);

                            Toast.makeText(getBaseContext(), personne.toString(), Toast.LENGTH_LONG).show();

                            }

                        }


        });


    /*    // GetContent creates an ActivityResultLauncher<String> to allow you to pass
        // in the mime type you'd like to allow the user to select
        ActivityResultLauncher<String> mGetContent = registerForActivityResult(new GetContent(),
                new ActivityResultCallback<Uri>() {
                    @Override
                    public void onActivityResult(Uri uri) {
                        // Handle the returned Uri
                    }
                });
*/

    }

    public void envoi(View view) {
        //on recupere les donnees du formulaire
        String nom = eNom.getText().toString();
        String prenom = ePrenom.getText().toString();

        // on instance un objet Personne
        Personne personne = new Personne(nom, prenom);
        // il n'y a pas de DB derriere pour l'auto-incrementation
        // de l'id, donc on lui donne ici tojours la même valeur
        // cette ligne est à supprimer losqu'on on rajoutera la db
        personne.setId(1);

        // on ajoute la personne à l'arraylist
        DaoPersonne.addPersonne(personne);

        // on va créer l'intent pour demarrer ListviewActivity
        // intend est un message servant pour envoyer au system android
        Intent intent = new Intent(this, ListViewActivity.class);
        // on stocke l'arrayLis de personne à envoyer à listViewActivity
        // dans intent
        intent.putExtra(MainActivity.LIST_PERSONNES,
                DaoPersonne.getAllPersonnes());
        // On lance l'intent
  //1:      startActivity(intent);
        // on remplace plus haut par Launcher
        intentActivityResultLauncher.launch(intent);

    }
}
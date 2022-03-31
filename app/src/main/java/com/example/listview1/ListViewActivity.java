package com.example.listview1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.listview1.model.Personne;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {

    ListView listView ;
    //on definit un ArrayAdaptateur pour adapter la liste des
    // personnes au listview
    ArrayAdapter<Personne> personneArrayAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        listView = findViewById(R.id.listView);
        // on recupere l'intent envoyé par la MainActivity
        Intent intent = getIntent();
        // on recupere l'ArrayList<Personne>
        ArrayList<Personne> personnes =
                (ArrayList<Personne>) intent.getSerializableExtra(MainActivity.LIST_PERSONNES);
        // on va instancier l'ArrayAdapter
        personneArrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,personnes);
        listView.setAdapter(personneArrayAdapter);
    }
}
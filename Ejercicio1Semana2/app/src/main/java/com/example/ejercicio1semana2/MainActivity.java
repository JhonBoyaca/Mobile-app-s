package com.example.ejercicio1semana2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    String[] horas = new String[200];
AutoCompleteTextView txtSelectAutoComplete;
ArrayAdapter<String> adapterItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i=0;i<110;i++) {

            horas[i] = "" + (i+1);
        }
            txtSelectAutoComplete = findViewById(R.id.txtSelectAutoComplete);

            adapterItems = new ArrayAdapter<String>(this, R.layout.list_item, horas);
            txtSelectAutoComplete.setAdapter(adapterItems);

          txtSelectAutoComplete.setOnItemClickListener(new AdapterView.OnItemClickListener() {
              @Override
              public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                  String item = parent.getItemAtPosition(position).toString();
                  Toast.makeText(getApplicationContext(), "Horas trabajadas: "+item,Toast.LENGTH_SHORT).show();


              }
          });

    }
    }

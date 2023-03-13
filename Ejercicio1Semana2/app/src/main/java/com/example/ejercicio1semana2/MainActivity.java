package com.example.ejercicio1semana2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    String[] horas = new String[100];
AutoCompleteTextView txtSelectAutoComplete;
ArrayAdapter<String> adapterItems;


    Button btnEnviarInfo;
    EditText txtDui, txtNombre,txtValorHoras;
    Integer horasItem=0;
    Double salario=1.0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        for(int i=0;i<=24;i++) {

            horas[i] = "" + (i+1);
        }
        btnEnviarInfo = findViewById(R.id.btnEnviar);
        txtSelectAutoComplete = findViewById(R.id.txtSelectAutoComplete);
        adapterItems = new ArrayAdapter<String>(this, R.layout.list_item, horas);
        txtSelectAutoComplete.setAdapter(adapterItems);

        txtSelectAutoComplete.setEnabled(false);

btnEnviarInfo.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {



        txtDui = findViewById(R.id.txtDUI);
        txtNombre = findViewById(R.id.txtNombre);
        txtValorHoras =findViewById(R.id.txtValorHora);

        Intent  info = new Intent(MainActivity.this,recibeInfo.class);
        info.putExtra("nombre","El nombre es: "+txtNombre.getText().toString());
        info.putExtra("dui","El Numero de DUI es: "+txtDui.getText().toString());
        info.putExtra("horas","Las horas laboradas son: "+horasItem.toString());
        info.putExtra("ValorHora","El valor por hora es: "+txtValorHoras.getText().toString());
        salario = Double.parseDouble(txtValorHoras.getText().toString())*horasItem;
        info.putExtra("salario","El salario es: "+(salario.toString()));

      startActivity(info);
    }
});


          txtSelectAutoComplete.setOnItemClickListener(new AdapterView.OnItemClickListener() {
              @Override
              public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                  horasItem = Integer.parseInt(parent.getItemAtPosition(position).toString());
                  String item = parent.getItemAtPosition(position).toString();
                  Toast.makeText(getApplicationContext(), "Horas trabajadas: "+item,Toast.LENGTH_SHORT).show();

              }
          });

    }
    }

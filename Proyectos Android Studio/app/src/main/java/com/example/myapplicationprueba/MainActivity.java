package com.example.myapplicationprueba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btnMEnviar;
    EditText edtNombre, edtCorreo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Instanciando al objeto
        btnMEnviar = findViewById(R.id.btnEnviar);
        edtNombre = findViewById(R.id.edtNombre);
        edtCorreo = findViewById(R.id.edtCorreo);
        //Creando el enlace para la segunda activity
        btnMEnviar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent act2 = new Intent(MainActivity.this,recibeInfo.class);
                //preparando los datos a enviar a la actividad destino
                //por medio de putExtra()
                act2.putExtra("nombre",edtNombre.getText().toString());
                act2.putExtra("correo",edtCorreo.getText().toString());
                //Enviando los datos a la activity destino
                startActivity(act2);
            }
        } );
    }
}
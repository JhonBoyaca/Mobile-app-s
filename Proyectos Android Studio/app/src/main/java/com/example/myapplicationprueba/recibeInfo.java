package com.example.myapplicationprueba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class recibeInfo extends AppCompatActivity {

    Button btnRegresar, btnSalir;
    TextView txtvNombre, txtvCorreo;
    String nombreEnviado=null, correoEnviado=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recibe_info);

        setContentView(R.layout.activity_recibe_info);
        btnRegresar = findViewById(R.id.btnRegresar);
        btnSalir = findViewById(R.id.btnSalir);
        txtvNombre = findViewById(R.id.txtvNombre);
        txtvCorreo = findViewById(R.id.txtvCorreo);
        //Empleando Bundle para pasar datos a través de varias activities
        //Proporciona putType() y getType()
        //Para almacenar y recuperar datos de él
        Bundle bundle = getIntent().getExtras();
        //Inicializando las variables con el valor de Bundle
        nombreEnviado = bundle.getString("nombre");
        correoEnviado = bundle.getString("correo");
        //Mostrando valores obtenidos
        txtvNombre.setText(nombreEnviado);
        txtvCorreo.setText(correoEnviado);
        //Accediendo al evento clic del botón Regresar
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent regresar = new Intent(recibeInfo.this,MainActivity.class);
                startActivity(regresar);
            }
        });//Fin btnRegresar
        btnSalir.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                //Eliminar todas las actividades que se tengan
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });//Fin btnSalir
    }
}
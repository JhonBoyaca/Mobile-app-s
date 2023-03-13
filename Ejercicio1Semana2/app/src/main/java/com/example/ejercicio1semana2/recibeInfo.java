package com.example.ejercicio1semana2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class recibeInfo extends AppCompatActivity {


    Button btnRegresar, btnSalir;
    TextView txtDui, txtNombre, txtSalario, txtHora, txtValorHora;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recibe_info);

        txtDui = findViewById(R.id.txtDUI);
        txtHora = findViewById(R.id.txtHorasLaboradas);
        txtNombre = findViewById(R.id.txtNombre);
        txtValorHora = findViewById(R.id.txtValorHora);
        txtSalario = findViewById(R.id.txtSalario);
btnRegresar = findViewById(R.id.btnRegresar);
btnSalir = findViewById(R.id.btnSalir);
        Bundle bundle = getIntent().getExtras();//Variable para obtener los datos de mi anterior View

        txtNombre.setText(bundle.getString("nombre"));
        txtDui.setText(bundle.getString("dui"));
        txtHora.setText(bundle.getString("horas"));
        txtValorHora.setText(bundle.getString("ValorHora"));
        txtSalario.setText(bundle.getString("salario"));

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regresar = new Intent(recibeInfo.this,MainActivity.class);
                startActivity(regresar);
            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

            }
        });

    }
}
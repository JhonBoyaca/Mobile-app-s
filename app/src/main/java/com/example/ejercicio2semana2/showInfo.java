package com.example.ejercicio2semana2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class showInfo extends AppCompatActivity {
    String notas="";
    TextView txtNotas,txtNombre,txtPromedio;
    Button btnSalir, btnRegresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_info);

        txtNombre = findViewById(R.id.txtNombre);
        txtNotas = findViewById(R.id.txtNotas);
        txtPromedio = findViewById(R.id.txtPromedio);
        btnRegresar = findViewById(R.id.btnRegresar);
        btnSalir = findViewById(R.id.btnSalir);

Bundle bundle = getIntent().getExtras();

txtNombre.setText(bundle.getString("nombre"));
notas+=(bundle.getString("Nota1"));
notas+=(bundle.getString("Nota2"));
notas+=(bundle.getString("Nota3"));
txtNotas.setText(notas);
txtPromedio.setText(bundle.getString("promedio"));

btnSalir.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
});

btnRegresar.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        Intent regresar = new Intent(showInfo.this,MainActivity.class);
        startActivity(regresar);

    }
});



    }
}
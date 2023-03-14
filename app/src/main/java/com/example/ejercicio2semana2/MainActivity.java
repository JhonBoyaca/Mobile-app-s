package com.example.ejercicio2semana2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnAgregar, btnProcesar;
    EditText txtNombre, txtNota;
    TextView txtRespuesta; int count=0;
    Double acum=0.0,promedio=0.0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        double[] nota = new double[3];



        btnAgregar = findViewById(R.id.btnAgregar);
        btnProcesar = findViewById(R.id.btnProcesar);
        txtNota = findViewById(R.id.txtNota);
        txtRespuesta = findViewById(R.id.txtRespuesta);
        txtNombre = findViewById(R.id.txtNombre);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(count<=2){


                nota[count]=Double.parseDouble(txtNota.getText().toString());
                txtRespuesta.setText("Nota "+(count+1)+" Agregada Correctamente");
                txtNota.setText("");
                count++;
                }else{
                    txtRespuesta.setText("Limite de notas alcanzado");
                }
            }
        });

        btnProcesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count>=2){

                    Intent data = new Intent(MainActivity.this,showInfo.class);
                    data.putExtra("nombre",txtNombre.getText().toString());

                    for(int i=0; i<=2;i++ ){
                        Double notaString;

                        notaString = nota[i];

                            data.putExtra("Nota"+(i+1),"La nota "+(i+1)+" es: "+notaString.toString()+" ");

                        acum+=nota[i];
                    }
                    promedio = acum/3;
                    if(promedio>=7){
                        data.putExtra("promedio","El promedio es: "+promedio.toString()+"\nPaso la materia");
                    }else if (promedio<7){
                        data.putExtra("promedio","El promedio es: "+promedio.toString()+"\nDejo la materia");
                    }

                    startActivity(data);

                }else if(count ==0){
                    txtRespuesta.setText("Debe agregar las notas que se le solicitan \nNotas Restantes 3");
                }else if (count ==1){
                    txtRespuesta.setText("Debe agregar las notas que se le solicitan \nNotas Restantes 2");
                 }else if (count ==2){
                txtRespuesta.setText("Debe agregar las notas que se le solicitan \nNotas Restantes 1");
            }
            }
        });

    }
}
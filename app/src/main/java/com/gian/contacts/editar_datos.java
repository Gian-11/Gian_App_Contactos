package com.gian.contacts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class editar_datos extends AppCompatActivity {

    Button detalles;
    TextView tvNombre, tvFecha, tvTel, tvEmail, tvDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editar_datos);


        detalles = (Button) findViewById(R.id.btnEditar);

        Bundle parametros = getIntent().getExtras();

        String nombre       = parametros.getString("Nombre");
        String dia        = parametros.getString("Dia");
        String mes        = parametros.getString("Mes");
        String año        = parametros.getString("Año");
        String tel          = parametros.getString("Telefono");
        String email        = parametros.getString("Email");
        String descripcion  = parametros.getString("Descripcion");

        tvNombre       = (TextView) findViewById(R.id.txtNombre2);
        tvFecha        = (TextView) findViewById(R.id.txtFecha);
        tvTel          = (TextView) findViewById(R.id.txtTel2);
        tvEmail        = (TextView) findViewById(R.id.txtEmail2);
        tvDescripcion  = (TextView) findViewById(R.id.txtDescripcion2);

        tvNombre.setText(getText(R.string.nombre) + " " + nombre);
        tvFecha.setText(getText(R.string.fecha) + " " + dia + "-" + mes + "-" + año);
        tvTel.setText(getText(R.string.ndetelefono) + " " + tel);
        tvEmail.setText(getText(R.string.email_pantalla2) + " " + email);
        tvDescripcion.setText(getText(R.string.descripcion) + " " + descripcion);

        detalles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
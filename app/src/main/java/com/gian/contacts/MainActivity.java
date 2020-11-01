package com.gian.contacts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText nombre;
    EditText telefono;
    EditText email;
    EditText descripcion;
    DatePicker fecha;
    Button siguiente;
    Button ok;
    Button cancelar;
    TextView elegir_fecha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = (EditText) findViewById(R.id.txtNombre);
        fecha = (DatePicker) findViewById(R.id.dtpFecha);
        telefono = (EditText) findViewById(R.id.txtTel);
        email = (EditText) findViewById(R.id.txtMail);
        descripcion = (EditText) findViewById(R.id.txtDescripcion);
        elegir_fecha = (TextView) findViewById(R.id.txtElegirFecha);


        int año = fecha.getYear();
        int mes = fecha.getMonth();
        int dia = fecha.getDayOfMonth();

        cancelar = (Button) findViewById(R.id.btnCancel);

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fecha.setEnabled(true);
                ok.setClickable(true);

            }
        });

        ok = (Button) findViewById(R.id.btnOK);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fecha.setEnabled(false);
                ok.setClickable(false);


            }
        });


        siguiente = (Button) findViewById(R.id.btnSiguiente);

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, editar_datos.class);
                intent.putExtra("Nombre", nombre.getText().toString());
                intent.putExtra("Dia", String.valueOf(fecha.getDayOfMonth()));
                intent.putExtra("Mes", String.valueOf(fecha.getMonth() + 1));
                intent.putExtra("Año", String.valueOf(fecha.getYear()));
                intent.putExtra("Email", email.getText().toString());
                intent.putExtra("Telefono", telefono.getText().toString());
                intent.putExtra("Descripcion", descripcion.getText().toString());

                if (nombre.length() <= 0) {
                    nombre.requestFocus();
                    nombre.setError("Inserte un nombre");
                } else if (telefono.length() <= 0) {
                    telefono.requestFocus();
                    telefono.setError("Inserte un número de teléfono");
                } else if (email.length() <= 0) {
                    email.requestFocus();
                    email.setError("Inserte un correo electrónico");
                } else if (ok.isClickable()) {
                    elegir_fecha.requestFocus();
                    elegir_fecha.setError("Confirme la fecha de nacimiento");
                } else {
                    startActivity(intent);
                }
            }


        });


    }
}

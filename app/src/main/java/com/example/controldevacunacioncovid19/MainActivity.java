package com.example.controldevacunacioncovid19;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView lblNombre = findViewById(R.id.lblNombre);
        EditText etNombre = findViewById(R.id.etNombre);
        TextView lblApellido = findViewById(R.id.lblApellido);
        EditText etApellido = findViewById(R.id.etApellido);
        TextView lblFechaNacimiento = findViewById(R.id.lblFechaNacimiento);
        EditText etFechaNacimiento = findViewById(R.id.etFechaNacimiento);
        Button btnCargarInformacion = findViewById(R.id.btnCargarInformacion);

        btnCargarInformacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = etNombre.getText().toString();
                String apellido = etApellido.getText().toString();
                String fechaNacimiento = etFechaNacimiento.getText().toString();

                if (nombre.isEmpty() || apellido.isEmpty() || fechaNacimiento.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Por favor completa todos los campos.", Toast.LENGTH_SHORT).show();
                } else {
                    // Mostrar un Toast con el mensaje de bienvenida
                    Toast.makeText(MainActivity.this, "¡Bienvenido, " + nombre + " " + apellido + "!", Toast.LENGTH_SHORT).show();

                    // Crear un Intent para pasar a la siguiente actividad
                    Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
                    intent.putExtra("nombre", nombre);
                    intent.putExtra("apellido", apellido);
                    intent.putExtra("fechaNacimiento", fechaNacimiento);
                    startActivity(intent);
                }
            }
        });
    }
}
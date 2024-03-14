package com.example.controldevacunacioncovid19;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);

        TextView tvNombre = findViewById(R.id.tvNombre);
        TextView tvApellido = findViewById(R.id.tvApellido);
        TextView tvPuestoLaboral = findViewById(R.id.tvPuestoLaboral);
        TextView tvVacunaAdministrada = findViewById(R.id.tvVacunaAdministrada);
        TextView tvFechaPrimeraDosis = findViewById(R.id.tvFechaPrimeraDosis);

        Button btnConsultaVacunacion = findViewById(R.id.btnConsultaVacunacion);
        btnConsultaVacunacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://205.211.224.182/webservice/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                ApiService apiService = retrofit.create(ApiService.class);

                Call<Empleado> call = apiService.getEmpleado("consulta_vacunacion");

                call.enqueue(new Callback<Empleado>() {
                    @Override
                    public void onResponse(Call<Empleado> call, Response<Empleado> response) {
                        if (response.isSuccessful()) {
                            Empleado empleado = response.body();

                            tvNombre.setText("Nombre: " + empleado.getNombre());
                            tvApellido.setText("Apellido: " + empleado.getApellido());
                            tvPuestoLaboral.setText("Puesto Laboral: " + empleado.getPuestoLaboral());
                            tvVacunaAdministrada.setText("Vacuna Administrada: " + empleado.getVacunaAdministrada());
                            tvFechaPrimeraDosis.setText("Fecha de Primera Dosis: " + empleado.getFechaPrimeraDosis());
                        } else {
                            // Manejar el caso de respuesta no exitosa
                        }
                    }

                    @Override
                    public void onFailure(Call<Empleado> call, Throwable t) {
                        // Manejar el caso de fallo en la llamada a la API
                    }
                });
            }
        });

        // Agregar el botón de volver
        Button btnVolver = findViewById(R.id.btnVolver);
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Volver a la pantalla anterior
                onBackPressed();
            }
        });
    }
}
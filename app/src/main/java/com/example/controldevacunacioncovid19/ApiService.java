package com.example.controldevacunacioncovid19;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("wsRestAppx.php")
    Call<Empleado> getEmpleado(@Query("function") String function);
}
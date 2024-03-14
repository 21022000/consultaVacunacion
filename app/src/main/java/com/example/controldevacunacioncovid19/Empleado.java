package com.example.controldevacunacioncovid19;

public class Empleado {
    private String nombre;
    private String apellido;
    private String puestoLaboral;
    private String vacunaAdministrada;
    private String fechaPrimeraDosis;

    // Constructor
    public Empleado(String nombre, String apellido, String puestoLaboral, String vacunaAdministrada, String fechaPrimeraDosis) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.puestoLaboral = puestoLaboral;
        this.vacunaAdministrada = vacunaAdministrada;
        this.fechaPrimeraDosis = fechaPrimeraDosis;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPuestoLaboral() {
        return puestoLaboral;
    }

    public void setPuestoLaboral(String puestoLaboral) {
        this.puestoLaboral = puestoLaboral;
    }

    public String getVacunaAdministrada() {
        return vacunaAdministrada;
    }

    public void setVacunaAdministrada(String vacunaAdministrada) {
        this.vacunaAdministrada = vacunaAdministrada;
    }

    public String getFechaPrimeraDosis() {
        return fechaPrimeraDosis;
    }

    public void setFechaPrimeraDosis(String fechaPrimeraDosis) {
        this.fechaPrimeraDosis = fechaPrimeraDosis;
    }
}
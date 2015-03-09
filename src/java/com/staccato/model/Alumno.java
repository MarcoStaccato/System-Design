package com.staccato.model;

public class Alumno {
    
    private String nombre;
    private String apePat;
    private String apeMat;
    private int edad;
    private String genero;
    private String licenciatura;
    private String semestre;

    public Alumno(String nombre, String apePat, String apeMat, int edad, String genero, String licenciatura, String semestre) {
        this.nombre = nombre;
        this.apePat = apePat;
        this.apeMat = apeMat;
        this.edad = edad;
        this.genero = genero;
        this.licenciatura = licenciatura;
        this.semestre = semestre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApePat() {
        return apePat;
    }

    public void setApePat(String apePat) {
        this.apePat = apePat;
    }

    public String getApeMat() {
        return apeMat;
    }

    public void setApeMat(String apeMat) {
        this.apeMat = apeMat;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getLicenciatura() {
        return licenciatura;
    }

    public void setLicenciatura(String licenciatura) {
        this.licenciatura = licenciatura;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }
}

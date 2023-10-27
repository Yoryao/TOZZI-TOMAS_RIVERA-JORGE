package com.backend.parcial.model;

public class Odontologo {
    private String apellido;
    private String nombre;
    private int matricula;
    private int id;

    public Odontologo(String apellido, String nombre, int matricula) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.matricula = matricula;
    }

    public Odontologo(String apellido, String nombre, int matricula, int id) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.matricula = matricula;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Odontologo{" +
                "apellido='" + apellido + '\'' +
                ", nombre='" + nombre + '\'' +
                ", matricula='" + matricula + '\'' +
                ", id=" + id +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
}

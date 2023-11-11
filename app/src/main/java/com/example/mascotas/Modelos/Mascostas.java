package com.example.mascotas.Modelos;

public class Mascostas {
    private final String id;
    private String raza;
    private String nombre;
    private int edad;

    public Mascostas(String ID,String raza, String nombre, int edad) {
        this.id=ID;
        this.raza = raza;
        this.nombre = nombre;
        this.edad = edad;

    }

    public Mascostas(String ID) {
        this.id=ID;
    }

    public String getID() {
        return id;
    }

    public String getRaza() {
        return raza;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return
                " ID='" + id + '\'' +
                " raza='" + raza + '\'' +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad ;


    }
}

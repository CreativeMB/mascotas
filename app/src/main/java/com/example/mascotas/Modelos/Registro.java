package com.example.mascotas.Modelos;

import java.util.ArrayList;

public class Registro {
    private ArrayList<Mascostas>listaMascotas=new ArrayList<>() ;

    public ArrayList<Mascostas> getListaMascotas() {
        return listaMascotas;
    }

    public void setAgregarMascotas(Mascostas mascota) {
        listaMascotas.add(mascota);

    }
}

package com.example.fermach.pulltorefresh;

import java.io.Serializable;

/**
 * Created by Fermach on 15/02/2018.
 */

public class Asignatura implements Serializable {

    private String nombre;
    private String profesor;

    public Asignatura(String nombre, String profesor) {
        this.nombre = nombre;
        this.profesor = profesor;
    }

    public Asignatura() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    @Override
    public String toString() {
        return "Asignatura{" +
                "nombre='" + nombre + '\'' +
                ", profesor='" + profesor + '\'' +
                '}';
    }
}

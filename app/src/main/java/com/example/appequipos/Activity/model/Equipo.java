package com.example.appequipos.Activity.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Equipo {

    /* ---- ATRIBUTOS -----*/
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name="id")
    private long idEquipo;
    @ColumnInfo(name="nombre")
    private String nombre;
    @ColumnInfo(name="deporte")
    private String deporte;

    public long getIdEquipo() {
        return idEquipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setIdEquipo(long idEquipo) {
        this.idEquipo = idEquipo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "nombre='" + nombre + '\'' +
                ", deporte='" + deporte + '\'' +
                '}';
    }
}


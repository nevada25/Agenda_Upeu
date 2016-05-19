package com.videumcorp.desarrolladorandroid.navigationdrawerandroiddesignsupportlibrarywithfragments.Modelo;

public class Area {
    String id_area;
    String nombre_area;
    String estado;
    String id_area_padre;
    String id_empresa;

    public Area() {
    }

    public Area(String id_area, String nombre_area, String estado, String id_area_padre, String id_empresa) {
        this.id_area = id_area;
        this.nombre_area = nombre_area;
        this.estado = estado;
        this.id_area_padre = id_area_padre;
        this.id_empresa = id_empresa;
    }

    public String getId_area() {
        return id_area;
    }

    public void setId_area(String id_area) {
        this.id_area = id_area;
    }

    public String getNombre_area() {
        return nombre_area;
    }

    public void setNombre_area(String nombre_area) {
        this.nombre_area = nombre_area;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getId_area_padre() {
        return id_area_padre;
    }

    public void setId_area_padre(String id_area_padre) {
        this.id_area_padre = id_area_padre;
    }

    public String getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(String id_empresa) {
        this.id_empresa = id_empresa;
    }
}

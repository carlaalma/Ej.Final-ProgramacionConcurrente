package com.example.proyectosmga.models;
public class AnalisisDatos {

    private String fuente;
    private String tipo;
    private String contenido;

    public AnalisisDatos() {}

    public AnalisisDatos(String fuente, String tipo, String contenido) {
        this.fuente = fuente;
        this.tipo = tipo;
        this.contenido = contenido;
    }

    public String getFuente() {
        return fuente;
    }

    public void setFuente(String fuente) {
        this.fuente = fuente;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}

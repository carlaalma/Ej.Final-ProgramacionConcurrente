package com.example.proyectosmga.models;

import java.time.LocalDateTime;

public class DatosSensor {
    private Long idSensor;
    private Double lectura;
    private LocalDateTime timestamp;

    public DatosSensor() {
    }

    public DatosSensor(Long idSensor, Double lectura, LocalDateTime timestamp) {
        this.idSensor = idSensor;
        this.lectura = lectura;
        this.timestamp = timestamp;
    }

    public Long getIdSensor() {
        return idSensor;
    }

    public void setIdSensor(Long idSensor) {
        this.idSensor = idSensor;
    }

    public Double getLectura() {
        return lectura;
    }

    public void setLectura(Double lectura) {
        this.lectura = lectura;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "DatosSensor{" +
                "idSensor=" + idSensor +
                ", lectura=" + lectura +
                ", timestamp=" + timestamp +
                '}';
    }
}
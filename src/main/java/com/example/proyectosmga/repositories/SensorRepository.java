package com.example.proyectosmga.repositories;

import com.example.proyectosmga.models.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorRepository extends JpaRepository<Sensor, Long> {
}

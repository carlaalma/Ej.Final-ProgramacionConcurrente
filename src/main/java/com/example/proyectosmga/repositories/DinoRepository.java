package com.example.proyectosmga.repositories;

import com.example.proyectosmga.models.Dinosaurio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DinoRepository  extends JpaRepository<Dinosaurio, Long> {
}

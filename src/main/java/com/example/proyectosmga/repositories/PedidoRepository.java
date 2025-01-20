package com.example.proyectosmga.repositories;

import com.example.proyectosmga.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long>  {
}

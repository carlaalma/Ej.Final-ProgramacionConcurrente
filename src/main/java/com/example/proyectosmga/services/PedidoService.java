package com.example.proyectosmga.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.proyectosmga.models.Pedido;
import com.example.proyectosmga.repositories.PedidoRepository;
import org.springframework.transaction.annotation.Transactional;
@Service
public class PedidoService {

    @Autowired
    public PedidoRepository pedidoRepository;

    @Transactional(rollbackFor = Exception.class)
    public Pedido createPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Transactional(readOnly = true)
    public Iterable<Pedido> findAllOrders() {
        return pedidoRepository.findAll();
    }

    @Transactional(rollbackFor = Exception.class)
    public void updateOrder(Pedido pedido) throws Exception {
        pedidoRepository.save(pedido);
        if (someConditionFails()) {
            throw new Exception("Simulated error");
        }
    }
    private boolean someConditionFails() {
        return true;
    }

}

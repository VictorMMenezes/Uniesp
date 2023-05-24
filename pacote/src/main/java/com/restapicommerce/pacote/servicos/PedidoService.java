package com.restapicommerce.pacote.servicos;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapicommerce.pacote.entidades.Pedido;
import com.restapicommerce.pacote.repositorios.PedidoRepository;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public void concluirPedido(Pedido pedido) {
        // Lógica para concluir o pedido
        pedidoRepository.save(pedido);
    }

    public void cancelarPedido(Long idPedido) {
        // Lógica para cancelar o pedido
        pedidoRepository.deleteById(idPedido);
    }

    public Optional<Pedido> buscarPedidoPorId(Long idPedido) {
        return pedidoRepository.findById(idPedido);
    }

    
}


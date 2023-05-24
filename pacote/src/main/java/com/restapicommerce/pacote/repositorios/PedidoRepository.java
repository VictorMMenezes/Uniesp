package com.restapicommerce.pacote.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.restapicommerce.pacote.entidades.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    
}

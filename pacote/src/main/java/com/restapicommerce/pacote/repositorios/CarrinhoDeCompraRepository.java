package com.restapicommerce.pacote.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restapicommerce.pacote.entidades.CarrinhoDeCompras;

public interface CarrinhoDeCompraRepository extends JpaRepository<CarrinhoDeCompras, Long>{
    
}

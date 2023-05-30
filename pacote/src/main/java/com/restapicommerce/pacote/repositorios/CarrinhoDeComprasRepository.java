package com.restapicommerce.pacote.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restapicommerce.pacote.entidades.CarrinhoDeCompras;

public interface CarrinhoDeComprasRepository extends JpaRepository<CarrinhoDeCompras, Long>{
    
}

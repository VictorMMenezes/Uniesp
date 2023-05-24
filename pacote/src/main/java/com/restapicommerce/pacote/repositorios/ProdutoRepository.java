package com.restapicommerce.pacote.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restapicommerce.pacote.entidades.Produto;

public interface ProdutoRepository extends JpaRepository<Produto,Long> {
    
}

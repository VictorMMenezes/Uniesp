package com.restapicommerce.pacote.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restapicommerce.pacote.entidades.ItemProduto;

public interface ItemProdutoRepository extends JpaRepository<ItemProduto, Long> {
    
}

package com.restapicommerce.pacote.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restapicommerce.pacote.entidades.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long>{
    
}

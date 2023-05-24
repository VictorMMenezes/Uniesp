package com.restapicommerce.pacote.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restapicommerce.pacote.entidades.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
}

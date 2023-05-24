package com.restapicommerce.pacote.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapicommerce.pacote.entidades.Usuario;
import com.restapicommerce.pacote.repositorios.UsuarioRepository;


@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario cadastraUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarUsuario(){
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscarUsuarioPorId(Long idUsuario){
        return usuarioRepository.findById(idUsuario);
    }

    public void removeUsuarioPorId(Long idUsuario){
        usuarioRepository.deleteById(idUsuario);
    }

    public void alteraUsuario(Usuario usuario){
        usuarioRepository.save(usuario);
    }

}
package com.restapicommerce.pacote.controladores;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.restapicommerce.pacote.entidades.Usuario;
import com.restapicommerce.pacote.servicos.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario salvar(@RequestBody Usuario usuario){
        return usuarioService.cadastraUsuario(usuario);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Usuario> listarUsuario(){
        return usuarioService.listarUsuario();
    }

    @GetMapping("/{idUsuario}")
    @ResponseStatus(HttpStatus.OK)
    public Usuario buscarUsuarioPorId(@PathVariable("idUsuario") Long idUsuario){
        return usuarioService.buscarUsuarioPorId(idUsuario)
            .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{idUsuario}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeUsuarioPorId(@PathVariable("idUsuario")Long idUsuario){
        usuarioService.buscarUsuarioPorId(idUsuario)
            .map(usuario -> {
                usuarioService.removeUsuarioPorId(usuario.getIdUsuario());
                return Void.TYPE;
            }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{idUsuario}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void alteraUsuario(@PathVariable("idUsuario")Long idUsuario, @RequestBody Usuario usuario){
        usuarioService.buscarUsuarioPorId(idUsuario)
            .map(usuarioBase -> {
                modelMapper.map(usuario, usuarioBase);
                usuarioService.alteraUsuario(usuarioBase);
                return Void.TYPE;
            }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

}

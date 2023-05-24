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

import com.restapicommerce.pacote.entidades.Endereco;
import com.restapicommerce.pacote.servicos.EnderecoService;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
    
    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Endereco salvar(@RequestBody Endereco endereco){
        return enderecoService.cadastraEndereco(endereco);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Endereco> listarEndereco(){
        return enderecoService.listarEndereco();
    }

    @GetMapping("/{idEndereco}")
    @ResponseStatus(HttpStatus.OK)
    public Endereco buscarEnderecoPorId(@PathVariable("idEndereco") Long idEndereco){
        return enderecoService.buscarEnderecoPorId(idEndereco)
            .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{idEndereco}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeEnderecoPorId(@PathVariable("idEndereco")Long idEndereco){
        enderecoService.buscarEnderecoPorId(idEndereco)
            .map(endereco -> {
                enderecoService.removeEnderecoPorId(endereco.getIdEndereco());
                return Void.TYPE;
            }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{idEndereco}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void alteraEndereco(@PathVariable("idEndereco")Long idEndereco, @RequestBody Endereco endereco){
        enderecoService.buscarEnderecoPorId(idEndereco)
            .map(enderecoBase -> {
                modelMapper.map(endereco, enderecoBase);
                enderecoService.alteraEndereco(enderecoBase);
                return Void.TYPE;
            }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

}

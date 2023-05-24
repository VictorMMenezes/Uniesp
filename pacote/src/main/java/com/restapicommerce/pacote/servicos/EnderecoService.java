package com.restapicommerce.pacote.servicos;

import java.util.Optional;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapicommerce.pacote.entidades.Endereco;
import com.restapicommerce.pacote.repositorios.EnderecoRepository;

@Service
public class EnderecoService {
    
    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco cadastraEndereco(Endereco endereco){
        return enderecoRepository.save(endereco);
    }

    public List<Endereco> listarEndereco(){
        return enderecoRepository.findAll();
    }

    public Optional<Endereco> buscarEnderecoPorId(Long idEndereco){
        return enderecoRepository.findById(idEndereco);
    }

    public void removeEnderecoPorId(Long idEndereco){
        enderecoRepository.deleteById(idEndereco);
    }

    public void alteraEndereco(Endereco endereco){
        enderecoRepository.save(endereco);
    }

}



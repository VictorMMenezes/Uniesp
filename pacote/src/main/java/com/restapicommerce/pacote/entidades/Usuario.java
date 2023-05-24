package com.restapicommerce.pacote.entidades;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idUsuario;

    @Column(name = "nomeUsuario", nullable = false)
    private String nomeUsuario;

    @Column(name = "emailUsuario")
    private String emailUsuario;

    @Column(name = "senhaUsuario")
    private String senhaUsuario;

    @Column(name = "cpfUsuario")
    private String cpfUsuario;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idUsuario")
    private List<Endereco> enderecos;


}

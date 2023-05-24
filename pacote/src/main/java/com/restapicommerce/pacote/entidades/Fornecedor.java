package com.restapicommerce.pacote.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Fornecedor{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idFornecedor;

    @JoinColumn(name = "nomeFornecedor")
    private String nomeFornecedor;

    @JoinColumn(name = "CNPJFornecedor")
    private String CNPJFornecedor;

}
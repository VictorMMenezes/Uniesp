package com.restapicommerce.pacote.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class FormaDePagamento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idFormaDePagamento;

    @Column(name = "tipoPagamento", nullable = false)
    private String tipoPagamento;

}

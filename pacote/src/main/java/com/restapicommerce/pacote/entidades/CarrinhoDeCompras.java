package com.restapicommerce.pacote.entidades;

import java.sql.Date;

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
public class CarrinhoDeCompras {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCarrinhoDeCompras;

    @Column(name = "valorTotal")
    private int valorTotal;

    @Column(name = "dataEmissao")
    private Date dataEmissao;

    @Column(name = "dataEntrada")
    private Date dataEntrada;

}

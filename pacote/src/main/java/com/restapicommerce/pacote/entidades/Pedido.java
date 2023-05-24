package com.restapicommerce.pacote.entidades;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Pedido{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPedido;
    
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;
    
    @ManyToOne
    @JoinColumn(name= "idEndereco")
    private Endereco endereco;

    @ManyToOne
    @JoinColumn(name = "idFormaPagamento")
    private FormaDePagamento formaDePagamento;

    @ManyToOne
    @JoinColumn(name = "idCarrinhoDeCompras")
    private CarrinhoDeCompras carrinhoDeCompras;
    
    @Column(name = "dataEntrada")
    private Date dataEntrada;
    
    @Column(name = "dataEmissao")
    private Date datEmissao;
    
    @Column(name = "desconto")
    private Double desconto;
    
    @Column(name = "valorTotal")
    private Double valorTotal;

}

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
public class ItemProduto {
     
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idItemProduto;

    @Column(name = "quantidade")
    private int quantidade;


}

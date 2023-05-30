package com.restapicommerce.pacote.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.restapicommerce.pacote.entidades.ItemProduto;
import com.restapicommerce.pacote.repositorios.ItemProdutoRepository;

@Service
public class ItemProdutoService {

    @Autowired
    private ItemProdutoRepository itemProdutoRepository;

    public ItemProduto criarItemProduto(ItemProduto itemProduto) {
        return itemProdutoRepository.save(itemProduto);
    }

    public ItemProduto atualizarItemProduto(Long idItemProduto, ItemProduto itemProdutoAtualizado) {
        ItemProduto itemProduto = buscarItemProdutoPorId(idItemProduto);

        itemProduto.setQuantidade(itemProdutoAtualizado.getQuantidade());
        // Atualize outros campos, se necessário

        return itemProdutoRepository.save(itemProduto);
    }

    public void excluirItemProduto(Long idItemProduto) {
        ItemProduto itemProduto = buscarItemProdutoPorId(idItemProduto);
        itemProdutoRepository.delete(itemProduto);
    }

    public ItemProduto buscarItemProdutoPorId(Long idItemProduto) {
        return itemProdutoRepository.findById(idItemProduto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item de produto não encontrado"));
    }
}


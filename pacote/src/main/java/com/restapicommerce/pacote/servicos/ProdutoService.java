package com.restapicommerce.pacote.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.restapicommerce.pacote.entidades.Produto;
import com.restapicommerce.pacote.repositorios.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> buscarProdutoPorId(Long idProduto) {
        return produtoRepository.findById(idProduto);
    }

    public Produto criarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public void atualizarProduto(Long idProduto, Produto produtoAtualizado) {
        Produto produto = buscarProdutoPorId(idProduto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));

        produto.setNomeProduto(produtoAtualizado.getNomeProduto());
        produto.setPrecoProduto(produtoAtualizado.getPrecoProduto());
        produto.setQtdEstoque(produtoAtualizado.getQtdEstoque());

        produtoRepository.save(produto);
    }

    public void excluirProduto(Long idProduto) {
        Produto produto = buscarProdutoPorId(idProduto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));

        produtoRepository.delete(produto);
    }

    public void atualizarEstoqueProduto(Long idProduto, int quantidade) {
        Produto produto = buscarProdutoPorId(idProduto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));

        int novoEstoque = produto.getQtdEstoque() - quantidade;

        if (novoEstoque < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Quantidade indisponível em estoque");
        }

        produto.setQtdEstoque(novoEstoque);

        produtoRepository.save(produto);
    }
}


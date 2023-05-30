package com.restapicommerce.pacote.servicos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.restapicommerce.pacote.entidades.CarrinhoDeCompras;
import com.restapicommerce.pacote.entidades.Produto;
import com.restapicommerce.pacote.repositorios.CarrinhoDeComprasRepository;
import com.restapicommerce.pacote.repositorios.ProdutoRepository;

@Service
public class CarrinhoDeCompraService {

    @Autowired
    private CarrinhoDeComprasRepository carrinhoDeComprasRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public void adicionarProduto(Long idCarrinhoDeCompras, Long idProduto) {
        CarrinhoDeCompras carrinho = buscarCarrinhoPorId(idCarrinhoDeCompras);
        Produto produto = buscarProdutoPorId(idProduto);

        List<Produto> produtos = getCarrinhoProdutos(carrinho);
        produtos.add(produto);
        carrinhoDeComprasRepository.save(carrinho);
    }

    public void removerProduto(Long idCarrinhoDeCompras, Long idProduto) {
        CarrinhoDeCompras carrinho = buscarCarrinhoPorId(idCarrinhoDeCompras);
        Produto produto = buscarProdutoPorId(idProduto);

        List<Produto> produtos = getCarrinhoProdutos(carrinho);
        produtos.remove(produto);
        carrinhoDeComprasRepository.save(carrinho);
    }

    public void atualizarQuantidadeProduto(Long idCarrinhoDeCompras, Long idProduto, int qtdEstoque) {
        CarrinhoDeCompras carrinho = buscarCarrinhoPorId(idCarrinhoDeCompras);
        Produto produto = buscarProdutoPorId(idProduto);

        if (qtdEstoque <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A quantidade deve ser maior que zero");
        }

        List<Produto> produtos = getCarrinhoProdutos(carrinho);
        produtos.remove(produto);
        for (int i = 0; i < qtdEstoque; i++) {
            produtos.add(produto);
        }

        carrinhoDeComprasRepository.save(carrinho);
    }

    private CarrinhoDeCompras buscarCarrinhoPorId(Long idCarrinhoDeCompras) {
        return carrinhoDeComprasRepository.findById(idCarrinhoDeCompras)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Carrinho de compras não encontrado"));
    }

    private Produto buscarProdutoPorId(Long idProduto) {
        return produtoRepository.findById(idProduto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));
    }

    @SuppressWarnings("unchecked")
    private List<Produto> getCarrinhoProdutos(CarrinhoDeCompras carrinho) {
        Object produtosObj = carrinho.getProdutos();
        if (produtosObj instanceof List<?>) {
            return (List<Produto>) produtosObj;
        } else {
            return new ArrayList<>();
        }
    }

    public void excluirCarrinhoDeCompras(Long id) {
        carrinhoDeComprasRepository.deleteById(id);
    }

    public void atualizarCarrinhoDeCompras(Long id, CarrinhoDeCompras carrinhoAtualizado) {
        CarrinhoDeCompras carrinho = buscarCarrinhoDeComprasPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Carrinho de compras não encontrado"));
        carrinhoDeComprasRepository.save(carrinho);
    }

    public CarrinhoDeCompras criarCarrinhoDeCompras(CarrinhoDeCompras carrinho) {
        return carrinhoDeComprasRepository.save(carrinho);
    }

    public Optional<CarrinhoDeCompras> buscarCarrinhoDeComprasPorId(Long id) {
        return carrinhoDeComprasRepository.findById(id);
    }

    public List<CarrinhoDeCompras> listarCarrinhosDeCompras() {
        return carrinhoDeComprasRepository.findAll();
    }
}

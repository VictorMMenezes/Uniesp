package com.restapicommerce.pacote.controladores;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapicommerce.pacote.entidades.CarrinhoDeCompras;
import com.restapicommerce.pacote.servicos.CarrinhoDeCompraService;

@RestController
@RequestMapping("/carrinhos")
public class CarrinhoDeComprasController {

    @Autowired
    private CarrinhoDeCompraService carrinhoDeCompraService;

    @GetMapping
    public ResponseEntity<List<CarrinhoDeCompras>> listarCarrinhosDeCompras() {
        List<CarrinhoDeCompras> carrinhos = carrinhoDeCompraService.listarCarrinhosDeCompras();
        return ResponseEntity.ok(carrinhos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarrinhoDeCompras> buscarCarrinhoDeCompras(@PathVariable Long id) {
        Optional<CarrinhoDeCompras> carrinho = carrinhoDeCompraService.buscarCarrinhoDeComprasPorId(id);
        return carrinho.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CarrinhoDeCompras> adicionarCarrinhoDeCompras(@RequestBody CarrinhoDeCompras carrinho) {
        CarrinhoDeCompras novoCarrinho = carrinhoDeCompraService.criarCarrinhoDeCompras(carrinho);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoCarrinho);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarrinhoDeCompras> atualizarCarrinhoDeCompras(
            @PathVariable Long id, @RequestBody CarrinhoDeCompras carrinhoAtualizado) {
        carrinhoDeCompraService.atualizarCarrinhoDeCompras(id, carrinhoAtualizado);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirCarrinhoDeCompras(@PathVariable Long id) {
        carrinhoDeCompraService.excluirCarrinhoDeCompras(id);
        return ResponseEntity.noContent().build();
    }
}


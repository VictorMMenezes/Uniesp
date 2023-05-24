package com.restapicommerce.pacote.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.restapicommerce.pacote.entidades.Pedido;
import com.restapicommerce.pacote.servicos.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping("/concluir")
    @ResponseStatus(HttpStatus.CREATED)
    public void concluirPedido(@RequestBody Pedido pedido) {
        pedidoService.concluirPedido(pedido);
    }

    @DeleteMapping("/{idPedido}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void cancelarPedido(@PathVariable("idPedido") Long idPedido) {
        pedidoService.cancelarPedido(idPedido);
    }

    @GetMapping("/{idPedido}")
    @ResponseStatus(HttpStatus.OK)
    public Pedido buscarPedidoPorId(@PathVariable("idPedido") Long idPedido) {
        return pedidoService.buscarPedidoPorId(idPedido)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

}


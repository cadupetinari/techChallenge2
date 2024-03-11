package com.fiap.control;

import com.fiap.model.ItemPedido;
import com.fiap.model.Pedido;
import com.fiap.usecase.PedidoUseCase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fastFoodApi/pedido")
@Api(value = "Pedido Controller", description = "Operações relacionadas a pedidos.")
public class PedidoController {

    private final PedidoUseCase pedidoUseCase;

    @Autowired
    public PedidoController(PedidoUseCase pedidoUseCase) {
        this.pedidoUseCase = pedidoUseCase;
    }

    @GetMapping
    @ApiOperation("Lista todos os pedidos")
    public List<Pedido> listarPedidos() {
        return pedidoUseCase.listarPedidos();
    }

    @GetMapping("/{id}")
    @ApiOperation("Obtém um pedido pelo ID")
    public ResponseEntity<Pedido> obterPedido(@PathVariable Long id) {
        Pedido pedido = pedidoUseCase.obterPedido(id);
        if (pedido != null) {
            return new ResponseEntity<>(pedido, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    @ApiOperation("Cria um novo pedido")
    public ResponseEntity<Long> criarPedido(@RequestBody Pedido pedido) {
        Long numeroPedido = pedidoUseCase.criarPedido(pedido);
        return new ResponseEntity<>(numeroPedido, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ApiOperation("Atualiza um pedido pelo ID")
    public ResponseEntity<Pedido> atualizarPedido(@PathVariable Long id, @RequestBody Pedido pedidoAtualizado) {
        Pedido pedidoAtualizadoSalvo = pedidoUseCase.atualizarPedido(id, pedidoAtualizado);
        if (pedidoAtualizadoSalvo != null) {
            return new ResponseEntity<>(pedidoAtualizadoSalvo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Exclui um pedido pelo ID")
    public ResponseEntity<Void> excluirPedido(@PathVariable Long id) {
        boolean sucesso = pedidoUseCase.excluirPedido(id);
        if (sucesso) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/checkout")
    @ApiOperation("Realiza o checkout do pedido")
    public ResponseEntity<Long> checkoutPedido(@RequestBody List<ItemPedido> itensPedido) {
        Long numeroPedido = pedidoUseCase.realizarCheckout(itensPedido);
        return new ResponseEntity<>(numeroPedido, HttpStatus.CREATED);
    }

    @GetMapping("/pagamento/{id}")
    @ApiOperation("Consulta o status do pagamento do pedido pelo ID")
    public ResponseEntity<String> consultarStatusPagamento(@PathVariable Long id) {
        String statusPagamento = pedidoUseCase.consultarStatusPagamento(id);
        if (statusPagamento != null) {
            return new ResponseEntity<>(statusPagamento, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Pedido não encontrado.", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/pagamento/{id}")
    @ApiOperation("Atualiza o status do pagamento do pedido pelo ID")
    public ResponseEntity<String> atualizarStatusPagamento(@PathVariable Long id, @RequestParam String novoStatus) {
        String statusAtualizado = pedidoUseCase.atualizarStatusPagamento(id, novoStatus);
        if (statusAtualizado != null) {
            return new ResponseEntity<>(statusAtualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Pedido não encontrado.", HttpStatus.NOT_FOUND);
        }
    }
}

package com.fiap.usecase;

import com.fiap.control.PedidoRepository;
import com.fiap.model.ItemPedido;
import com.fiap.model.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PedidoUseCase {

    private final PedidoRepository pedidoRepository;

    @Autowired
    public PedidoUseCase(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll()
                .stream()
                .filter(p -> !p.getStatus().equals("Finalizado"))
                .sorted(Comparator.comparing(Pedido::getStatus)
                        .thenComparing(Pedido::getDataCriacao))
                .collect(Collectors.toList());
    }

    public Pedido obterPedido(Long id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    public Long criarPedido(Pedido pedido) {
        Pedido novoPedido = pedidoRepository.save(pedido);
        return novoPedido.getId();
    }

    public Pedido atualizarPedido(Long id, Pedido pedidoAtualizado) {
        if (pedidoRepository.existsById(id)) {
            pedidoAtualizado.setId(id);
            return pedidoRepository.save(pedidoAtualizado);
        } else {
            return null;
        }
    }

    public boolean excluirPedido(Long id) {
        if (pedidoRepository.existsById(id)) {
            pedidoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public Long realizarCheckout(List<ItemPedido> itensPedido) {
        // Implementar lógica para realizar o checkout do pedido
        // Retornar o número do pedido gerado
        return 0L; // Exemplo de retorno
    }

    public String consultarStatusPagamento(Long id) {
        Pedido pedido = pedidoRepository.findById(id).orElse(null);
        if (pedido != null) {
            return pedido.getStatusPagamento();
        } else {
            return null;
        }
    }

    public String atualizarStatusPagamento(Long id, String novoStatus) {
        Pedido pedido = pedidoRepository.findById(id).orElse(null);
        if (pedido != null) {
            pedido.setStatusPagamento(novoStatus);
            pedidoRepository.save(pedido);
            return "Status de pagamento atualizado com sucesso.";
        } else {
            return null;
        }
    }
}

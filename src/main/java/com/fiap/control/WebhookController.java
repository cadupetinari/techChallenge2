package com.fiap.control;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "Webhook Controller", description = "Operações relacionadas à integração de webhooks para atualização do status de pagamento.")
public class WebhookController {

    @PostMapping("/fastFoodApi/webhook/pagamento")
    @ApiOperation(value = "Recebe a confirmação de pagamento e atualiza o status do pedido.")
    public ResponseEntity<String> receberConfirmacaoPagamento(@RequestParam Long idPedido,
                                                               @RequestParam String statusPagamento) {
        // Simulação do recebimento de confirmação de pagamento
        // Aqui você pode implementar a lógica real de integração com a Mercado Pago

        // Exemplo de mock
        if (statusPagamento.equals("aprovado") || statusPagamento.equals("recusado")) {
            // Você pode implementar essa lógica de atualização do status do pedido usando o PedidoUseCase
            return new ResponseEntity<>("Status de pagamento atualizado com sucesso.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Status de pagamento desconhecido.", HttpStatus.BAD_REQUEST);
        }
    }
}
package br.edu.ceub;
// Serviço responsável por processar o pagamento do pedido.
// Retorna um boolean indicando se o pagamento foi realizado com sucesso.

public class PaymentService {
    public boolean processPayment(Order order, double amount) {
        // Simulação de processamento de pagamento (lógica acoplada e sem abstração)
        System.out.println("Processando pagamento de " + amount + " para o pedido " + order.getOrderId());
        return true;
    }
}

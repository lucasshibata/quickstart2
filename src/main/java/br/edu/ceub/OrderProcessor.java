package br.edu.ceub;

// Processador de pedidos que centraliza diversas responsabilidades:
//  - Cálculo do total do pedido
//  - Aplicação de descontos via DiscountService
//  - Verificação de estoque via InventoryService
//  - Processamento de pagamento via PaymentService
//  - Persistência do pedido via OrderRepository
//  - Envio de notificação via EmailService
// Além disso, possui métodos que retornam valores para facilitar a comunicação dos resultados.
class OrderProcessor {
    // Método que calcula o total bruto do pedido.
    public double computeTotal(Order order) {
        double total = 0;
        for (OrderItem item : order.getItems()) {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }

    // Método que gera um resumo do pedido.
    public String getOrderSummary(Order order, double finalTotal) {
        StringBuilder summary = new StringBuilder();
        summary.append("Resumo do Pedido ").append(order.getOrderId()).append(":\n");
        for (OrderItem item : order.getItems()) {
            summary.append(item.getName())
                    .append(" - Quantidade: ").append(item.getQuantity())
                    .append(" - Preço Unitário: ").append(item.getPrice()).append("\n");
        }
        summary.append("Total Final: ").append(finalTotal);
        return summary.toString();
    }

    // Método principal que processa o pedido e retorna um boolean indicando sucesso ou falha.
    public boolean process(Order order) {
        // Cálculo do total bruto
        double total = computeTotal(order);

        // Aplicação de desconto
        DiscountService discountService = new DiscountService();
        double discount = discountService.calculateDiscount(order);
        double finalTotal = total - discount;

        // Verificação de estoque
        InventoryService inventoryService = new InventoryService();
        if (!inventoryService.checkInventory(order)) {
            System.out.println("Falha na verificação de estoque para o pedido " + order.getOrderId());
            return false;
        }

        // Processamento do pagamento
        PaymentService paymentService = new PaymentService();
        if (!paymentService.processPayment(order, finalTotal)) {
            System.out.println("Pagamento falhou para o pedido " + order.getOrderId());
            return false;
        }

        // Persistência do pedido
        OrderRepository repository = new OrderRepository();
        if (!repository.saveOrder(order, finalTotal)) {
            System.out.println("Falha ao salvar o pedido " + order.getOrderId());
            return false;
        }

        // Envio de notificação por email
        EmailService emailService = new EmailService();
        if (!emailService.sendEmail("cliente@example.com", "Seu pedido foi processado com sucesso. " +
                "Resumo:\n" + getOrderSummary(order, finalTotal))) {
            System.out.println("Falha no envio de email para o pedido " + order.getOrderId());
            return false;
        }

        return true;
    }
}

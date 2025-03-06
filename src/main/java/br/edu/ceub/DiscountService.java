package br.edu.ceub;
// Serviço responsável por calcular descontos com base no total do pedido.

public class DiscountService {
    public double calculateDiscount(Order order) {
        double total = 0;
        for (OrderItem item : order.getItems()) {
            total += item.getPrice() * item.getQuantity();
        }
        // Regra de negócio: 15% de desconto se total for maior que 200; 10% se maior que 100.
        if (total > 200) {
            return total * 0.15;
        } else if (total > 100) {
            return total * 0.10;
        }
        return 0;
    }
}

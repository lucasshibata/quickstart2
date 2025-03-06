package br.edu.ceub;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PaymentServiceTest {

    @Test
    void processPayment_pay_250_return_true() {
        //preparar
        List<OrderItem> items = List.of(
                new OrderItem("Produto A", 60.0, 1),
                new OrderItem("Produto B", 50.0, 2),
                new OrderItem("Produto C", 30.0, 3)
        );
        Order order = new Order("ORD123", items);
        PaymentService paymentService = new PaymentService();

        //executar
        boolean result = paymentService.processPayment(order, 250);

        //verificar
        assertTrue(result);
    }
    @Test
    void processPayment_pay_240_return_false() {
        //preparar
        List<OrderItem> items = List.of(
                new OrderItem("Produto A", 60.0, 1),
                new OrderItem("Produto B", 50.0, 2),
                new OrderItem("Produto C", 30.0, 3)
        );
        Order order = new Order("ORD123", items);
        PaymentService paymentService = new PaymentService();

        //executar
        boolean result = paymentService.processPayment(order, 240);

        //verificar
        assertFalse(result);
    }
}
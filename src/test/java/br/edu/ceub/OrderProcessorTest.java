package br.edu.ceub;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderProcessorTest {

    @Test
    void computeTotal_250_return_total_250() {
        //preparar
        List<OrderItem> items = List.of(
                new OrderItem("Produto A", 60.0, 1),
                new OrderItem("Produto B", 50.0, 2),
                new OrderItem("Produto C", 30.0, 3)
        );
        Order order = new Order("ORD123", items);
        OrderProcessor orderProcessor = new OrderProcessor();

        //executar
        double result = orderProcessor.computeTotal(order);

        //verificar
        assertEquals(250, result);
    }
}
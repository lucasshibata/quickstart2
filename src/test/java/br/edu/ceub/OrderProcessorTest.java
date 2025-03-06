package br.edu.ceub;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderProcessorTest {
    List<OrderItem> items;
    Order order;
    OrderProcessor orderProcessor;

    @BeforeEach
    void init() {
        items = List.of(
                new OrderItem("Produto A", 60.0, 1),
                new OrderItem("Produto B", 50.0, 2),
                new OrderItem("Produto C", 30.0, 3)
        );
        order = new Order("ORD123", items);
        orderProcessor = new OrderProcessor();
    }
    @Test
    void computeTotal_250_return_total_250() {
        //preparar

        //executar
        double result = orderProcessor.computeTotal(order);

        //verificar
        assertEquals(250, result);
    }

    @Test
    void process(){
        //preparar


        //executar
        boolean result = orderProcessor.process(order);

        //verificar
        assertFalse(result);
    }
}
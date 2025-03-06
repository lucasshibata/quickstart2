package br.edu.ceub;

import java.util.List;

// Representa o pedido contendo uma lista de itens.
public class Order {
    private List<OrderItem> items;
    private String orderId; // ID do pedido para rastreamento

    public Order(String orderId, List<OrderItem> items) {
        this.orderId = orderId;
        this.items = items;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public String getOrderId() {
        return orderId;
    }
}

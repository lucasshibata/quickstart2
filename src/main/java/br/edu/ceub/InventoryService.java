package br.edu.ceub;
// Serviço que verifica se há estoque disponível para os itens do pedido.
// Retorna true se todos os itens estiverem disponíveis; caso contrário, false.

public class InventoryService {
    public boolean checkInventory(Order order) {
        // Simulação: se algum item tiver quantidade superior a 10, assume estoque insuficiente.
        for (OrderItem item : order.getItems()) {
            if (item.getQuantity() > 10) {
                return false;
            }
        }
        return true;
    }
}

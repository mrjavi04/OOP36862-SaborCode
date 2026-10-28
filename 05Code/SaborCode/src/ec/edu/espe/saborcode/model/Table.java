package ec.edu.espe.saborcode.model;

/**
 *
 * @author Javi
 */
public class Table {
    private int tableNumber;
    private int capacity;
    private String status;
    private Order currentOrder;

    public Table(int tableNumber, int capacity) {
        this.tableNumber = tableNumber;
        this.capacity = capacity;
        this.status = "Libre";
        this.currentOrder = null;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getStatus() {
        return status;
    }

    public Order getCurrentOrder() {
        return currentOrder;
    }

    public void occupyTable(Order order) {
        this.status = "Ocupada";
        this.currentOrder = order;
    }

    public void releaseTable() {
        this.status = "Libre";
        this.currentOrder = null;
    }

    @Override
    public String toString() {
        return "Mesa " + tableNumber + " - Capacidad: " + capacity + " | Estado: " + status;
    }
}
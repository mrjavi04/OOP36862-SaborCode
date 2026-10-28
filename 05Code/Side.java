package ec.edu.espe.saborcode.model;

/**
 *
 * @author Javi
 */
public class Side {
    private int id;
    private String name;
    private int quantity;

    public Side(int id, String name) {
        this.id = id;
        this.name = name;
        this.quantity = 1;
    }

    public Side(Side baseSide, int quantity) {
        this.id = baseSide.getId();
        this.name = baseSide.getName();
        this.quantity = quantity;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getQuantity() { return quantity; }

    @Override
    public String toString() {
        return quantity + "x " + name + " (Cortesia)";
    }
}
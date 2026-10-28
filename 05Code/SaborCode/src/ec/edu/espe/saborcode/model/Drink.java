package ec.edu.espe.saborcode.model;

/**
 *
 * @author Javi
 */
public class Drink {
    private int id;
    private String name;
    private double price;
    private int quantity;

    public Drink(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = 1;
    }

    public Drink(Drink baseDrink, int quantity) {
        this.id = baseDrink.getId();
        this.name = baseDrink.getName();
        this.price = baseDrink.getPrice();
        this.quantity = quantity;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    public double getSubtotal() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return quantity + "x " + name + " ($" + String.format("%.2f", price) + " c/u) - Subtotal: $" + String.format("%.2f", getSubtotal());
    }
}
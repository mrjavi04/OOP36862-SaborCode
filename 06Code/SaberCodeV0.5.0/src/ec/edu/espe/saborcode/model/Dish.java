package ec.edu.espe.saborcode.model;

/**
 *
 * @author Javi
 */
public class Dish {
    private int id;
    private String name;
    private double price;
    private String description;

    public Dish(int id, String name, double price, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getDescription() { return description; }

    public void setId(int id) { 
        this.id = id; 
    }
    
    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
    public void setDescription(String description) { this.description = description; }

    @Override
    public String toString() {
        return id + ". " + name + " - $" + String.format("%.2f", price) + " | " + description;
    }
}
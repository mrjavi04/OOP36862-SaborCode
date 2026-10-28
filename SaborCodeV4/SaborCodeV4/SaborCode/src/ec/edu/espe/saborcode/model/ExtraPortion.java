package ec.edu.espe.saborcode.model;

/**
 *
 * @author Javi
 */
public class ExtraPortion {
    private int id;
    private String name;
    private double price;
    private int quantity;
    private String selectedPieces;

    public ExtraPortion(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = 1;
        this.selectedPieces = "";
    }

    public ExtraPortion(ExtraPortion baseExtra, int quantity) {
        this.id = baseExtra.getId();
        this.name = baseExtra.getName();
        this.price = baseExtra.getPrice();
        this.quantity = quantity;
        this.selectedPieces = "";
    }

    public ExtraPortion(ExtraPortion baseExtra, int quantity, String selectedPieces) {
        this.id = baseExtra.getId();
        this.name = baseExtra.getName();
        this.price = baseExtra.getPrice();
        this.quantity = quantity;
        this.selectedPieces = selectedPieces;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public String getSelectedPieces() { return selectedPieces; }

    public double getSubtotal() {
        return price * quantity;
    }

    @Override
    public String toString() {
        String text = quantity + "x Porcion extra de " + name + 
                      " ($" + String.format("%.2f", price) + " c/u) - Subtotal: $" + 
                      String.format("%.2f", getSubtotal());
        if (!selectedPieces.isEmpty()) {
            text += "\n      -> Presa(s) extra elegida(s): " + selectedPieces;
        }
        return text;
    }
}
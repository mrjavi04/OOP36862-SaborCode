package ec.edu.espe.saborcode.model;

/**
 *
 * @author Javi
 */
public class OrderDetail {
    private Dish dish;
    private int quantity;
    private String selectedPieces;

    public OrderDetail(Dish dish, int quantity) {
        this.dish = dish;
        this.quantity = quantity;
        this.selectedPieces = "";
    }

    public OrderDetail(Dish dish, int quantity, String selectedPieces) {
        this.dish = dish;
        this.quantity = quantity;
        this.selectedPieces = selectedPieces;
    }

    public Dish getDish() { return dish; }
    public int getQuantity() { return quantity; }
    public String getSelectedPieces() { return selectedPieces; }
    
    public double getSubtotal() { 
        return dish.getPrice() * quantity; 
    }

    @Override
    public String toString() {
        String text = quantity + "x " + dish.getName() + 
                      " ($" + String.format("%.2f", dish.getPrice()) + " c/u) - Subtotal: $" + 
                      String.format("%.2f", getSubtotal());
        if (!selectedPieces.isEmpty()) {
            text += "\n      -> Presa(s) elegida(s): " + selectedPieces;
        }
        return text;
    }
}
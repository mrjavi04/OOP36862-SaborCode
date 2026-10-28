package ec.edu.espe.saborcode.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Javi
 */
public class Order {
    private int id;
    private int tableNumber;
    private List<OrderDetail> details;
    private List<Drink> drinks;
    private List<Side> sides;
    private List<ExtraPortion> extraPortions;
    private Tip tip;

    public Order(int id, int tableNumber) {
        this.id = id;
        this.tableNumber = tableNumber;
        this.details = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.sides = new ArrayList<>();
        this.extraPortions = new ArrayList<>();
        this.tip = new Tip(0);
    }

    public void addDetail(OrderDetail detail) {
        details.add(detail);
    }

    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    public void addSide(Side side) {
        sides.add(side);
    }

    public void addExtraPortion(ExtraPortion extra) {
        extraPortions.add(extra);
    }

    public void setTip(Tip tip) {
        this.tip = tip;
    }

    public double calculateSubtotal() {
        double subtotal = 0;
        for (OrderDetail d : details) {
            subtotal += d.getSubtotal();
        }
        for (Drink dr : drinks) {
            subtotal += dr.getSubtotal();
        }
        for (ExtraPortion ep : extraPortions) {
            subtotal += ep.getSubtotal();
        }
        return subtotal;
    }

    public double calculateTotal() {
        double subtotal = calculateSubtotal();
        double tipAmount = tip.calculateTipAmount(subtotal);
        return subtotal + tipAmount;
    }

    public int getId() { return id; }
    public int getTableNumber() { return tableNumber; }
    public List<OrderDetail> getDetails() { return details; }
    public List<Drink> getDrinks() { return drinks; }
    public List<Side> getSides() { return sides; }
    public List<ExtraPortion> getExtraPortions() { return extraPortions; }
    public Tip getTip() { return tip; }
}
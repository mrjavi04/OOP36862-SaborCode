package ec.edu.espe.saborcode.model;

/**
 *
 * @author Javi
 */
public class Tip {
    private double percentage;

    public Tip(double percentage) {
        this.percentage = percentage;
    }

    public double getPercentage() { 
        return percentage; 
    }

    public double calculateTipAmount(double orderSubtotal) {
        return orderSubtotal * (percentage / 100.0);
    }
}
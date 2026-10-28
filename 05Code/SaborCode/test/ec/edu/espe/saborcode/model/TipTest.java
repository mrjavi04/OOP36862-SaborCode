package ec.edu.espe.saborcode.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class TipTest {

    @Test
    public void testCase1_CreateTipAndGetPercentage() {
        Tip tip = new Tip(10.0);
        assertEquals(10.0, tip.getPercentage(), 0.001);
    }

    @Test
    public void testCase2_CalculateTenPercentTip() {
        Tip tip = new Tip(10.0);
        double amount = tip.calculateTipAmount(20.00);
        assertEquals(2.00, amount, 0.001);
    }

    @Test
    public void testCase3_CalculateZeroTip() {
        Tip tip = new Tip(0.0);
        double amount = tip.calculateTipAmount(15.50);
        assertEquals(0.00, amount, 0.001);
    }

    @Test
    public void testCase4_CalculateFifteenPercentTip() {
        Tip tip = new Tip(15.0);
        double amount = tip.calculateTipAmount(40.00);
        assertEquals(6.00, amount, 0.001);
    }

    @Test
    public void testCase5_CalculateTipWithZeroSubtotal() {
        Tip tip = new Tip(10.0);
        double amount = tip.calculateTipAmount(0.00);
        assertEquals(0.00, amount, 0.001);
    }

    @Test
    public void testCase6_CalculateCustomTipPercentage() {
        Tip tip = new Tip(5.5);
        double amount = tip.calculateTipAmount(100.00);
        assertEquals(5.50, amount, 0.001);
    }

    @Test
    public void testCase7_CalculateHundredPercentTip() {
        Tip tip = new Tip(100.0);
        double amount = tip.calculateTipAmount(12.50);
        assertEquals(12.50, amount, 0.001);
    }

    @Test
    public void testCase8_TipObjectNotNull() {
        Tip tip = new Tip(10.0);
        assertNotNull(tip);
    }

    @Test
    public void testCase9_FailOnIncorrectTipCalculation() {
        Tip tip = new Tip(10.0);
        double amount = tip.calculateTipAmount(20.00);
        assertEquals(5.00, amount, 0.001);
    }

    @Test
    public void testCase10_FailOnIncorrectPercentage() {
        Tip tip = new Tip(15.0);
        assertEquals(10.0, tip.getPercentage(), 0.001);
    }
}
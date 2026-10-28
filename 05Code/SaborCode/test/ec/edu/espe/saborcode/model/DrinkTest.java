package ec.edu.espe.saborcode.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class DrinkTest {
    @Test
    public void testCase1_CreateDrinkAndGetters() {
        Drink drink = new Drink(1, "Coca-Cola", 1.50);
        assertEquals(1, drink.getId());
        assertEquals("Coca-Cola", drink.getName());
        assertEquals(1.50, drink.getPrice(), 0.001);
        assertEquals(1, drink.getQuantity());
    }

    @Test
    public void testCase2_DrinkWithQuantityConstructor() {
        Drink baseDrink = new Drink(2, "Fanta", 1.50);
        Drink orderedDrink = new Drink(baseDrink, 3);
        
        assertEquals(2, orderedDrink.getId());
        assertEquals("Fanta", orderedDrink.getName());
        assertEquals(1.50, orderedDrink.getPrice(), 0.001);
        assertEquals(3, orderedDrink.getQuantity());
    }

    @Test
    public void testCase3_CalculateSubtotalSingle() {
        Drink drink = new Drink(3, "Sprite", 1.50);
        assertEquals(1.50, drink.getSubtotal(), 0.001);
    }

    @Test
    public void testCase4_CalculateSubtotalMultiple() {
        Drink baseDrink = new Drink(4, "Pepsi", 1.25);
        Drink orderedDrink = new Drink(baseDrink, 4);
        
        assertEquals(5.00, orderedDrink.getSubtotal(), 0.001);
    }

    @Test
    public void testCase5_CheckGallitoDrink() {
        Drink drink = new Drink(5, "Gallito", 1.00);
        assertEquals("Gallito", drink.getName());
        assertEquals(1.00, drink.getPrice(), 0.001);
    }

    @Test
    public void testCase6_CheckFuzeTeaDrink() {
        Drink drink = new Drink(6, "Fuze Tea", 1.50);
        assertEquals(6, drink.getId());
        assertEquals(1.50, drink.getPrice(), 0.001);
    }

    @Test
    public void testCase7_CheckColadaMoradaDrink() {
        Drink drink = new Drink(7, "Colada Morada", 2.50);
        assertEquals("Colada Morada", drink.getName());
        assertEquals(2.50, drink.getPrice(), 0.001);
    }

    @Test
    public void testCase8_ToStringFormat() {
        Drink baseDrink = new Drink(1, "Coca-Cola", 1.50);
        Drink orderedDrink = new Drink(baseDrink, 2);
        
        assertTrue(orderedDrink.toString().contains("Coca-Cola"));
        assertTrue(orderedDrink.toString().contains("3,00") || orderedDrink.toString().contains("3.00"));
    }

    @Test
    public void testCase9_ZeroQuantityOrCustom() {
        Drink drink = new Drink(8, "Agua Mineral", 1.00);
        assertEquals(1, drink.getQuantity());
    }

    @Test
    public void testCase10_FailOnIncorrectSubtotal() {
        Drink baseDrink = new Drink(1, "Coca-Cola", 1.50);
        Drink orderedDrink = new Drink(baseDrink, 2);
        
        assertEquals(10.00, orderedDrink.getSubtotal(), 0.001);
    }
}
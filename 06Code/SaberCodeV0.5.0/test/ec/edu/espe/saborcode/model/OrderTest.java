package ec.edu.espe.saborcode.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class OrderTest {
    @Test
    public void testCase1_InitialOrderEmpty() {
        Order order = new Order(1001, 2);
        assertEquals(1001, order.getId());
        assertEquals(2, order.getTableNumber());
        assertEquals(0.0, order.calculateSubtotal(), 0.001);
    }

    @Test
    public void testCase2_AddDetailSubtotal() {
        Order order = new Order(1002, 1);
        Dish dish = new Dish(1, "Parrillada Normal", 2.75, "Pollo");
        order.addDetail(new OrderDetail(dish, 2));
        assertEquals(5.50, order.calculateSubtotal(), 0.001);
    }

    @Test
    public void testCase3_AddDrinkSubtotal() {
        Order order = new Order(1003, 3);
        Drink baseDrink = new Drink(1, "Coca-Cola", 1.50);
        order.addDrink(new Drink(baseDrink, 2)); 
        assertEquals(3.00, order.calculateSubtotal(), 0.001);
    }

    @Test
    public void testCase4_AddExtraPortionSubtotal() {
        Order order = new Order(1004, 4);
        ExtraPortion baseExtra = new ExtraPortion(8, "Presa de Pollo", 2.50);
        order.addExtraPortion(new ExtraPortion(baseExtra, 1)); 
        assertEquals(2.50, order.calculateSubtotal(), 0.001);
    }

    @Test
    public void testCase5_AddSideSubtotal() {
        Order order = new Order(1005, 5);
        Side baseSide = new Side(1, "Mayonesa");
        order.addSide(new Side(baseSide, 2)); 
        assertEquals(0.00, order.calculateSubtotal(), 0.001);
    }

    @Test
    public void testCase6_CalculateCompleteSubtotal() {
        Order order = new Order(1006, 6);
        Dish dish = new Dish(1, "Parrillada Normal", 2.75, "Pollo");
        order.addDetail(new OrderDetail(dish, 1));
        ExtraPortion extra = new ExtraPortion(1, "Papas Chauchas", 1.00);
        order.addExtraPortion(new ExtraPortion(extra, 1));
        Drink drink = new Drink(1, "Coca-Cola", 1.50);
        order.addDrink(new Drink(drink, 1));
        assertEquals(5.25, order.calculateSubtotal(), 0.001);
    }

    @Test
    public void testCase7_CalculateTotalWithTip() {
        Order order = new Order(1007, 1);
        Dish dish = new Dish(1, "Parrillada Normal", 10.00, "Pollo");
        order.addDetail(new OrderDetail(dish, 1));
        order.setTip(new Tip(10.0)); 
        assertEquals(11.00, order.calculateTotal(), 0.001);
    }

    @Test
    public void testCase8_ListCollectionsNotNull() {
        Order order = new Order(1008, 2);
        assertNotNull(order.getDetails());
        assertNotNull(order.getDrinks());
        assertNotNull(order.getSides());
        assertNotNull(order.getExtraPortions());
    }

    @Test
    public void testCase9_FailOnIncorrectSubtotal() {
        Order order = new Order(1009, 3);
        Dish dish = new Dish(1, "Parrillada Normal", 2.75, "Pollo");
        order.addDetail(new OrderDetail(dish, 1));
        assertEquals(50.00, order.calculateSubtotal(), 0.001);
    }

    @Test
    public void testCase10_FailOnIncorrectTotalWithTip() {
        Order order = new Order(1010, 4);
        Dish dish = new Dish(1, "Parrillada Normal", 10.00, "Pollo");
        order.addDetail(new OrderDetail(dish, 1));
        order.setTip(new Tip(10.0));
        assertEquals(20.00, order.calculateTotal(), 0.001);
    }
}
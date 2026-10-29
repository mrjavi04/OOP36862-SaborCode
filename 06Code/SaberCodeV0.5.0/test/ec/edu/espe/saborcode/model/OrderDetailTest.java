package ec.edu.espe.saborcode.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class OrderDetailTest {
    @Test
    public void testCase1_CreateOrderDetailWithoutPieces() {
        Dish dish = new Dish(8, "Habas con Queso", 1.50, "Habas con queso");
        OrderDetail detail = new OrderDetail(dish, 3);
        
        assertEquals(dish, detail.getDish());
        assertEquals(3, detail.getQuantity());
        assertEquals("", detail.getSelectedPieces());
        assertEquals(4.50, detail.getSubtotal(), 0.001);
    }

    @Test
    public void testCase2_CreateOrderDetailWithPieces() {
        Dish dish = new Dish(1, "Parrillada Normal", 2.75, "Pollo y guarnicion");
        OrderDetail detail = new OrderDetail(dish, 2, "Ala, Pechuga");
        
        assertEquals(dish, detail.getDish());
        assertEquals(2, detail.getQuantity());
        assertEquals("Ala, Pechuga", detail.getSelectedPieces());
        assertEquals(5.50, detail.getSubtotal(), 0.001);
    }

    @Test
    public void testCase3_ToStringFormatContainsDetails() {
        Dish dish = new Dish(1, "Parrillada Normal", 2.75, "Pollo y guarnicion");
        OrderDetail detail = new OrderDetail(dish, 1, "Pierna");
        
        assertTrue(detail.toString().contains("Parrillada Normal"));
        assertTrue(detail.toString().contains("Pierna"));
    }

    @Test
    public void testCase4_FailOnIncorrectSubtotal() {
        Dish dish = new Dish(8, "Habas con Queso", 1.50, "Habas con queso");
        OrderDetail detail = new OrderDetail(dish, 3);
        
        assertEquals(20.00, detail.getSubtotal(), 0.001);
    }

    @Test
    public void testCase5_FailOnIncorrectQuantity() {
        Dish dish = new Dish(8, "Habas con Queso", 1.50, "Habas con queso");
        OrderDetail detail = new OrderDetail(dish, 3);
        
        assertEquals(10, detail.getQuantity());
    }

    @Test
    public void testCase6_FailOnIncorrectSelectedPieces() {
        Dish dish = new Dish(1, "Parrillada Normal", 2.75, "Pollo");
        OrderDetail detail = new OrderDetail(dish, 1, "Ala");
        
        assertEquals("Rabadilla", detail.getSelectedPieces());
    }

    @Test
    public void testCase7_FailOnIncorrectDishName() {
        Dish dish = new Dish(8, "Habas con Queso", 1.50, "Habas con queso");
        OrderDetail detail = new OrderDetail(dish, 1);
        
        assertEquals("Choclo", detail.getDish().getName());
    }

    @Test
    public void testCase8_FailOnIncorrectDishPrice() {
        Dish dish = new Dish(8, "Habas con Queso", 1.50, "Habas con queso");
        OrderDetail detail = new OrderDetail(dish, 1);
        
        assertEquals(5.00, detail.getDish().getPrice(), 0.001);
    }

    @Test
    public void testCase9_FailOnIncorrectSubtotalWithPieces() {
        Dish dish = new Dish(1, "Parrillada Normal", 2.75, "Pollo");
        OrderDetail detail = new OrderDetail(dish, 2, "Ala, Pechuga");
        
        assertEquals(10.00, detail.getSubtotal(), 0.001);
    }

    @Test
    public void testCase10_FailOnNotNullSelectedPieces() {
        Dish dish = new Dish(8, "Habas con Queso", 1.50, "Habas con queso");
        OrderDetail detail = new OrderDetail(dish, 1);
        
        assertEquals("Pechuga", detail.getSelectedPieces());
    }
}
package ec.edu.espe.saborcode.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class DishTest {

    @Test
    public void testCase1_CreateDishAndGetters() {
        Dish dish = new Dish(1, "Parrillada Normal", 2.75, "Presa de pollo, papas chauchas");
        assertEquals(1, dish.getId());
        assertEquals("Parrillada Normal", dish.getName());
        assertEquals(2.75, dish.getPrice(), 0.001);
        assertEquals("Presa de pollo, papas chauchas", dish.getDescription());
    }

    @Test
    public void testCase2_UpdateDishName() {
        Dish dish = new Dish(2, "Choclo", 1.00, "Choclo con queso");
        dish.setName("Choclo Especial");
        assertEquals("Choclo Especial", dish.getName());
    }

    @Test
    public void testCase3_UpdateDishPrice() {
        Dish dish = new Dish(3, "Habas con Queso", 1.50, "Habas tiernas");
        dish.setPrice(1.80);
        assertEquals(1.80, dish.getPrice(), 0.001);
    }

    @Test
    public void testCase4_UpdateDishDescription() {
        Dish dish = new Dish(4, "Platano Asado", 1.00, "Maduro asado");
        dish.setDescription("Maduro asado con queso tierno");
        assertEquals("Maduro asado con queso tierno", dish.getDescription());
    }

    @Test
    public void testCase5_UpdateDishId() {
        Dish dish = new Dish(5, "Parrillada de Mollejas", 2.75, "Mollejas y papas");
        dish.setId(99);
        assertEquals(99, dish.getId());
    }

    @Test
    public void testCase6_ToStringFormat() {
        Dish dish = new Dish(6, "Parrillada Mixta", 3.50, "Pollo y chorizo");
        assertTrue(dish.toString().contains("Parrillada Mixta"));
        assertTrue(dish.toString().contains("3,50") || dish.toString().contains("3.50"));
    }

    @Test
    public void testCase7_ZeroPriceDish() {
        Dish dish = new Dish(7, "Agua de Cortesia", 0.00, "Vaso de agua");
        assertEquals(0.00, dish.getPrice(), 0.001);
    }

    @Test
    public void testCase8_CorrectPriceComparison() {
        Dish dish = new Dish(8, "Parrillada de Patitas", 1.75, "Patitas de pollo");
        assertEquals(1.75, dish.getPrice(), 0.001);
    }

    @Test
    public void testCase9_CorrectDishName() {
        Dish dish = new Dish(9, "Coca-Cola", 1.50, "Bebida helada");
        assertEquals("Coca-Cola", dish.getName());
    }

    @Test
    public void testCase10_CorrectDishId() {
        Dish dish = new Dish(10, "Fanta", 1.50, "Bebida sabor naranja");
        assertEquals(10, dish.getId());
    }
}
package ec.edu.espe.saborcode.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class SideTest {

    @Test
    public void testCase1_CreateSideAndGetters() {
        Side side = new Side(1, "Mayonesa");
        assertEquals(1, side.getId());
        assertEquals("Mayonesa", side.getName());
        assertEquals(1, side.getQuantity());
    }

    @Test
    public void testCase2_SideWithQuantityConstructor() {
        Side baseSide = new Side(2, "Sal");
        Side orderedSide = new Side(baseSide, 3);
        
        assertEquals(2, orderedSide.getId());
        assertEquals("Sal", orderedSide.getName());
        assertEquals(3, orderedSide.getQuantity());
    }

    @Test
    public void testCase3_CheckAjiSide() {
        Side side = new Side(3, "Aji");
        assertEquals("Aji", side.getName());
    }

    @Test
    public void testCase4_ToStringFormatContainsCortesia() {
        Side baseSide = new Side(4, "Pimienta");
        Side orderedSide = new Side(baseSide, 2);
        
        assertTrue(orderedSide.toString().contains("Pimienta"));
        assertTrue(orderedSide.toString().contains("Cortesia"));
    }

    @Test
    public void testCase5_CheckMostazaSide() {
        Side side = new Side(5, "Mostaza");
        assertEquals(5, side.getId());
        assertEquals("Mostaza", side.getName());
    }

    @Test
    public void testCase6_FailOnIncorrectId() {
        Side side = new Side(1, "Mayonesa");
        assertEquals(99, side.getId());
    }

    @Test
    public void testCase7_FailOnIncorrectName() {
        Side side = new Side(2, "Sal");
        assertEquals("Salsa de Tomate", side.getName());
    }

    @Test
    public void testCase8_FailOnIncorrectQuantity() {
        Side side = new Side(3, "Aji");
        assertEquals(10, side.getQuantity());
    }

    @Test
    public void testCase9_FailOnIncorrectToStringFormat() {
        Side side = new Side(4, "Pimienta");
        assertTrue(side.toString().contains("Mayonesa Especial"));
    }

    @Test
    public void testCase10_FailOnIncorrectSideObjectMatch() {
        Side baseSide = new Side(6, "Salsa de Tomate");
        Side orderedSide = new Side(baseSide, 4);
        assertEquals(1, orderedSide.getId());
    }
}
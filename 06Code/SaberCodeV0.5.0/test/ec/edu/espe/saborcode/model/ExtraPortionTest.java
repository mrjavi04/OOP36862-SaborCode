package ec.edu.espe.saborcode.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class ExtraPortionTest {
    @Test
    public void testCase1_CreateExtraPortionAndGetters() {
        ExtraPortion extra = new ExtraPortion(1, "Papas Chauchas", 1.00);
        assertEquals(1, extra.getId());
        assertEquals("Papas Chauchas", extra.getName());
        assertEquals(1.00, extra.getPrice(), 0.001);
        assertEquals(1, extra.getQuantity());
        assertEquals("", extra.getSelectedPieces());
    }

    @Test
    public void testCase2_ExtraPortionWithQuantityConstructor() {
        ExtraPortion baseExtra = new ExtraPortion(2, "Habas", 1.00);
        ExtraPortion orderedExtra = new ExtraPortion(baseExtra, 3);
        
        assertEquals(2, orderedExtra.getId());
        assertEquals("Habas", orderedExtra.getName());
        assertEquals(1.00, orderedExtra.getPrice(), 0.001);
        assertEquals(3, orderedExtra.getQuantity());
    }

    @Test
    public void testCase3_ExtraPortionWithChickenPiecesConstructor() {
        ExtraPortion baseChicken = new ExtraPortion(8, "Presa de Pollo", 2.50);
        ExtraPortion orderedChicken = new ExtraPortion(baseChicken, 2, "Pierna, Pospierna");
        
        assertEquals(8, orderedChicken.getId());
        assertEquals("Presa de Pollo", orderedChicken.getName());
        assertEquals(2.50, orderedChicken.getPrice(), 0.001);
        assertEquals(2, orderedChicken.getQuantity());
        assertEquals("Pierna, Pospierna", orderedChicken.getSelectedPieces());
    }

    @Test
    public void testCase4_CalculateSubtotalStandard() {
        ExtraPortion baseExtra = new ExtraPortion(3, "Tostado", 1.00);
        ExtraPortion orderedExtra = new ExtraPortion(baseExtra, 4);
        
        assertEquals(4.00, orderedExtra.getSubtotal(), 0.001);
    }

    @Test
    public void testCase5_CalculateSubtotalChickenPiece() {
        ExtraPortion baseChicken = new ExtraPortion(8, "Presa de Pollo", 2.50);
        ExtraPortion orderedChicken = new ExtraPortion(baseChicken, 2, "Ala, Pechuga");
        
        assertEquals(5.00, orderedChicken.getSubtotal(), 0.001);
    }

    @Test
    public void testCase6_ToStringFormatStandard() {
        ExtraPortion baseExtra = new ExtraPortion(4, "Ensalada", 1.00);
        ExtraPortion orderedExtra = new ExtraPortion(baseExtra, 1);
        
        assertTrue(orderedExtra.toString().contains("Ensalada"));
        assertTrue(orderedExtra.toString().contains("1,00") || orderedExtra.toString().contains("1.00"));
    }

    @Test
    public void testCase7_FailOnIncorrectSubtotal() {
        ExtraPortion baseExtra = new ExtraPortion(1, "Papas Chauchas", 1.00);
        ExtraPortion orderedExtra = new ExtraPortion(baseExtra, 3);
        
        assertEquals(10.00, orderedExtra.getSubtotal(), 0.001);
    }

    @Test
    public void testCase8_FailOnIncorrectPrice() {
        ExtraPortion baseChicken = new ExtraPortion(8, "Presa de Pollo", 2.50);
        
        assertEquals(5.00, baseChicken.getPrice(), 0.001);
    }

    @Test
    public void testCase9_FailOnIncorrectQuantity() {
        ExtraPortion extra = new ExtraPortion(5, "Embutido", 1.00);
        
        assertEquals(5, extra.getQuantity());
    }

    @Test
    public void testCase10_FailOnIncorrectSelectedPieces() {
        ExtraPortion baseChicken = new ExtraPortion(8, "Presa de Pollo", 2.50);
        ExtraPortion orderedChicken = new ExtraPortion(baseChicken, 1, "Ala");
        
        assertEquals("Pechuga", orderedChicken.getSelectedPieces());
    }
}
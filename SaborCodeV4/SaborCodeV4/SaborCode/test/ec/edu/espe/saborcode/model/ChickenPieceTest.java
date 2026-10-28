package ec.edu.espe.saborcode.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class ChickenPieceTest {

    @Test
    public void testCase1_CreateChickenPieceAla() {
        ChickenPiece piece = new ChickenPiece(1, "Ala");
        assertEquals(1, piece.getId());
        assertEquals("Ala", piece.getName());
    }

    @Test
    public void testCase2_CreateChickenPiecePierna() {
        ChickenPiece piece = new ChickenPiece(2, "Pierna");
        assertEquals(2, piece.getId());
        assertEquals("Pierna", piece.getName());
    }

    @Test
    public void testCase3_CreateChickenPiecePospierna() {
        ChickenPiece piece = new ChickenPiece(3, "Pospierna");
        assertEquals(3, piece.getId());
        assertEquals("Pospierna", piece.getName());
    }

    @Test
    public void testCase4_CreateChickenPiecePechuga() {
        ChickenPiece piece = new ChickenPiece(4, "Pechuga");
        assertEquals(4, piece.getId());
        assertEquals("Pechuga", piece.getName());
    }

    @Test
    public void testCase5_ToStringFormat() {
        ChickenPiece piece = new ChickenPiece(4, "Pechuga");
        assertEquals("4. Pechuga", piece.toString());
    }

    @Test
    public void testCase6_CorrectIdCheck() {
        ChickenPiece piece = new ChickenPiece(1, "Ala");
        assertEquals(1, piece.getId()); 
    }

    @Test
    public void testCase7_CorrectNameCheck() {
        ChickenPiece piece = new ChickenPiece(2, "Pierna");
        assertEquals("Pierna", piece.getName()); 
    }

    @Test
    public void testCase8_CorrectToStringFormat() {
        ChickenPiece piece = new ChickenPiece(3, "Pospierna");
        assertEquals("3. Pospierna", piece.toString()); 
    }

    @Test
    public void testCase9_CorrectRabadillaId() {
        ChickenPiece piece = new ChickenPiece(5, "Rabadilla");
        assertEquals(5, piece.getId()); 
    }

    @Test
    public void testCase10_CorrectNameRabadilla() {
        ChickenPiece piece = new ChickenPiece(5, "Rabadilla");
        assertEquals("Rabadilla", piece.getName()); 
    }
}
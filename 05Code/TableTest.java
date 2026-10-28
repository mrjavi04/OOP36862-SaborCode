package ec.edu.espe.saborcode.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class TableTest {

    @Test
    public void testCase1_InitialTableStatus() {
        Table table = new Table(5, 6);
        assertEquals(5, table.getTableNumber());
        assertEquals(6, table.getCapacity());
        assertEquals("Libre", table.getStatus());
        assertNull(table.getCurrentOrder());
    }

    @Test
    public void testCase2_OccupyTableChangesStatus() {
        Table table = new Table(1, 4);
        Order order = new Order(1001, 1);
        table.occupyTable(order);
        
        assertEquals("Ocupada", table.getStatus());
        assertNotNull(table.getCurrentOrder());
        assertEquals(1001, table.getCurrentOrder().getId());
    }

    @Test
    public void testCase3_ReleaseTableResetsStatus() {
        Table table = new Table(2, 4);
        Order order = new Order(1002, 2);
        table.occupyTable(order);
        table.releaseTable();
        
        assertEquals("Libre", table.getStatus());
        assertNull(table.getCurrentOrder());
    }

    @Test
    public void testCase4_TableCapacityFour() {
        Table table = new Table(3, 4);
        assertEquals(4, table.getCapacity());
    }

    @Test
    public void testCase5_TableCapacitySix() {
        Table table = new Table(6, 6);
        assertEquals(6, table.getCapacity());
    }

    @Test
    public void testCase6_TableNumberAssignment() {
        Table table = new Table(4, 4);
        assertEquals(4, table.getTableNumber());
    }

    @Test
    public void testCase7_ToStringFormatContainsDetails() {
        Table table = new Table(1, 4);
        assertTrue(table.toString().contains("Mesa 1"));
        assertTrue(table.toString().contains("Capacidad: 4"));
        assertTrue(table.toString().contains("Libre"));
    }

    @Test
    public void testCase8_ToStringFormatWhenOccupied() {
        Table table = new Table(2, 4);
        Order order = new Order(1003, 2);
        table.occupyTable(order);
        
        assertTrue(table.toString().contains("Ocupada"));
    }

    @Test
    public void testCase9_MultipleOccupyAndReleaseCycles() {
        Table table = new Table(5, 6);
        Order order1 = new Order(1004, 5);
        
        table.occupyTable(order1);
        assertEquals("Ocupada", table.getStatus());
        
        table.releaseTable();
        assertEquals("Libre", table.getStatus());
        
        Order order2 = new Order(1005, 5);
        table.occupyTable(order2);
        assertEquals("Ocupada", table.getStatus());
        assertEquals(1005, table.getCurrentOrder().getId());
    }
    @Test
    public void testCase10_FailOnIncorrectInitialStatus() {
        Table table = new Table(1, 4);
        assertEquals("Ocupada", table.getStatus());
    }
}
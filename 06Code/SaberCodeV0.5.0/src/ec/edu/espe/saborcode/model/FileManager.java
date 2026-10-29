/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.saborcode.model;

import ec.edu.espe.saborcode.controller.MenuController;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Javi
 */
public class FileManager {

    public static void exportOrderToCSV(Order order) {
        String filename = "reporte_orden_" + order.getId() + ".csv";
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            pw.println("Categoria;Descripcion;Cantidad;Precio Unitario;Subtotal");
            
            for (OrderDetail od : order.getDetails()) {
                pw.println("Platillo;" + od.getDish().getName() + ";" + od.getQuantity() + ";" + od.getDish().getPrice() + ";" + od.getSubtotal());
            }
            for (ExtraPortion ep : order.getExtraPortions()) {
                pw.println("Porcion Extra;" + ep.getName() + ";" + ep.getQuantity() + ";" + ep.getPrice() + ";" + ep.getSubtotal());
            }
            for (Drink d : order.getDrinks()) {
                pw.println("Bebida;" + d.getName() + ";" + d.getQuantity() + ";" + d.getPrice() + ";" + d.getSubtotal());
            }
            
            pw.println(";;;Subtotal;" + order.calculateSubtotal());
            pw.println(";;;Total con Propina;" + order.calculateTotal());
            
            System.out.println("-> Reporte CSV generado con exito: " + filename);
        } catch (IOException e) {
            System.out.println("-> Error al exportar el reporte CSV: " + e.getMessage());
        }
    }

    public static void saveMenuToJson(MenuController menuCtrl) {
        String filename = "menu_saborcode.json";
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            pw.println("{");
            
            // 1. Platillos
            pw.println("  \"dishes\": [");
            for (int i = 0; i < menuCtrl.getMenu().size(); i++) {
                var d = menuCtrl.getMenu().get(i);
                pw.print("    { \"id\": " + d.getId() + ", \"name\": \"" + d.getName() + "\", \"price\": " + d.getPrice() + ", \"description\": \"" + d.getDescription() + "\" }");
                if (i < menuCtrl.getMenu().size() - 1) pw.println(","); else pw.println();
            }
            pw.println("  ],");

            // 2. Presas de Pollo
            pw.println("  \"chickenPieces\": [");
            for (int i = 0; i < menuCtrl.getChickenPiecesMenu().size(); i++) {
                var cp = menuCtrl.getChickenPiecesMenu().get(i);
                pw.print("    { \"id\": " + cp.getId() + ", \"name\": \"" + cp.getName() + "\" }");
                if (i < menuCtrl.getChickenPiecesMenu().size() - 1) pw.println(","); else pw.println();
            }
            pw.println("  ],");

            // 3. Porciones Extra
            pw.println("  \"extraPortions\": [");
            for (int i = 0; i < menuCtrl.getExtraPortionsMenu().size(); i++) {
                var ep = menuCtrl.getExtraPortionsMenu().get(i);
                pw.print("    { \"id\": " + ep.getId() + ", \"name\": \"" + ep.getName() + "\", \"price\": " + ep.getPrice() + " }");
                if (i < menuCtrl.getExtraPortionsMenu().size() - 1) pw.println(","); else pw.println();
            }
            pw.println("  ],");

            // 4. Bebidas
            pw.println("  \"drinks\": [");
            for (int i = 0; i < menuCtrl.getDrinksMenu().size(); i++) {
                var b = menuCtrl.getDrinksMenu().get(i);
                pw.print("    { \"id\": " + b.getId() + ", \"name\": \"" + b.getName() + "\", \"price\": " + b.getPrice() + " }");
                if (i < menuCtrl.getDrinksMenu().size() - 1) pw.println(","); else pw.println();
            }
            pw.println("  ],");

            // 5. Acompañamientos
            pw.println("  \"sides\": [");
            for (int i = 0; i < menuCtrl.getSidesMenu().size(); i++) {
                var s = menuCtrl.getSidesMenu().get(i);
                pw.print("    { \"id\": " + s.getId() + ", \"name\": \"" + s.getName() + "\" }");
                if (i < menuCtrl.getSidesMenu().size() - 1) pw.println(","); else pw.println();
            }
            pw.println("  ]");

            pw.println("}");
            System.out.println("-> Datos guardados en JSON exitosamente: " + filename);
        } catch (IOException e) {
            System.out.println("-> Error al guardar el archivo JSON: " + e.getMessage());
        }
    }
}
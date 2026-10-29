package ec.edu.espe.saborcode.view;

import ec.edu.espe.saborcode.controller.MenuController;
import ec.edu.espe.saborcode.model.ChickenPiece;
import ec.edu.espe.saborcode.model.Dish;
import ec.edu.espe.saborcode.model.Drink;
import ec.edu.espe.saborcode.model.ExtraPortion;
import ec.edu.espe.saborcode.model.FileManager;
import ec.edu.espe.saborcode.model.Order;
import ec.edu.espe.saborcode.model.OrderDetail;
import ec.edu.espe.saborcode.model.Side;
import ec.edu.espe.saborcode.model.Table;
import ec.edu.espe.saborcode.model.Tip;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Javi
 */
public class SaborCode {
    public static void main(String[] args) {
        MenuController menuCtrl = new MenuController();
        Scanner scanner = new Scanner(System.in);
        
        FileManager.saveMenuToJson(menuCtrl);
        
        List<Table> restaurantTables = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            restaurantTables.add(new Table(i, 4)); 
        }
        restaurantTables.add(new Table(5, 6)); 
        restaurantTables.add(new Table(6, 6)); 

        int tablesFor4 = 0;
        int tablesFor6 = 0;
        
        System.out.println("=== BIENVENIDO A SABORCODE ===");
        System.out.println("--- ESTADO ACTUAL DEL RESTAURANTE ---");
        
        for (Table t : restaurantTables) {
            System.out.println(t.toString());
            if (t.getStatus().equals("Libre")) {
                if (t.getCapacity() == 4) tablesFor4++;
                if (t.getCapacity() == 6) tablesFor6++;
            }
        }
        
        System.out.println("\nRESUMEN DE DISPONIBILIDAD:");
        System.out.println("- Mesas para 4 personas disponibles: " + tablesFor4);
        System.out.println("- Mesas para 6 personas disponibles: " + tablesFor6);

        System.out.print("\nIngrese el numero de mesa que desea ocupar (1 al 6): ");
        int selectedNumber = scanner.nextInt();
        scanner.nextLine();
        
        Table selectedTable = restaurantTables.get(selectedNumber - 1);
        
        int uniqueOrderId = (int) (System.currentTimeMillis() % 1000000);
        Order currentOrder = new Order(uniqueOrderId, selectedTable.getTableNumber()); 
        
        selectedTable.occupyTable(currentOrder); 
        
        System.out.println("\nMesa asignada exitosamente.");
        System.out.println("Actualmente ocupando: " + selectedTable.toString());

        int option = 0;
        while (option != 4) {
            System.out.println("\n=== MENU DIGITAL ===");
            System.out.println("1. Ver catalogo completo (Platillos, Porciones Extra, Bebidas y Acompanamientos)");
            System.out.println("2. Realizar pedido (Plato, Extras, Bebida y Acompanamientos)");
            System.out.println("3. Ver mi orden actual y pedir la cuenta");
            System.out.println("4. Salir");
            System.out.print("Elija una opcion: ");
            
            if (!scanner.hasNextInt()) {
                System.out.println("Por favor, ingrese un numero valido.");
                scanner.nextLine();
                continue;
            }
            option = scanner.nextInt();
            scanner.nextLine(); 

            switch (option) {
                case 1:
                    showMenu(menuCtrl);
                    showExtraPortions(menuCtrl);
                    showDrinks(menuCtrl);
                    showSides(menuCtrl);
                    break;

                case 2:
                    showMenu(menuCtrl);
                    System.out.print("\nIngrese el ID del platillo que desea ordenar (1 al 10): ");
                    int selectedId = scanner.nextInt();
                    scanner.nextLine(); 

                    Dish chosenDish = null;
                    for (Dish d : menuCtrl.getMenu()) { 
                        if (d.getId() == selectedId) {
                            chosenDish = d;
                            break;
                        }
                    }

                    if (chosenDish != null) {
                        System.out.println("Ha seleccionado: " + chosenDish.getName());
                        System.out.print("Cuantas unidades de " + chosenDish.getName() + " desea ordenar?: ");
                        int quantity = scanner.nextInt();
                        scanner.nextLine();
                        if (quantity <= 0) quantity = 1;

                        String selectedChickenPieces = "";
                        if (chosenDish.getId() >= 1 && chosenDish.getId() <= 4) {
                            selectedChickenPieces = selectChickenPieces(menuCtrl, scanner, quantity);
                        }

                        OrderDetail newDetail = new OrderDetail(chosenDish, quantity, selectedChickenPieces);
                        currentOrder.addDetail(newDetail);
                        System.out.println("-> " + quantity + "x " + chosenDish.getName() + " agregado(s) a su orden!");

                        showExtraPortions(menuCtrl);
                        int extraId = -1;
                        while (extraId != 0) {
                            System.out.print("\nDesea agregar alguna porcion extra? (Ingrese el ID del 1 al 8, o 0 para continuar): ");
                            extraId = scanner.nextInt();
                            scanner.nextLine();

                            if (extraId > 0) {
                                ExtraPortion chosenExtra = null;
                                for (ExtraPortion ep : menuCtrl.getExtraPortionsMenu()) {
                                    if (ep.getId() == extraId) {
                                        chosenExtra = ep;
                                        break;
                                    }
                                }

                                if (chosenExtra != null) {
                                    System.out.print("Cuantas porciones extra de " + chosenExtra.getName() + " desea?: ");
                                    int extraQty = scanner.nextInt();
                                    scanner.nextLine();
                                    if (extraQty <= 0) extraQty = 1;

                                    String selectedExtraPieces = "";
                                    if (chosenExtra.getId() == 8) {
                                        selectedExtraPieces = selectChickenPieces(menuCtrl, scanner, extraQty);
                                    }

                                    ExtraPortion orderedExtra = new ExtraPortion(chosenExtra, extraQty, selectedExtraPieces);
                                    currentOrder.addExtraPortion(orderedExtra);
                                    System.out.println("-> " + extraQty + "x Porcion extra de " + chosenExtra.getName() + " agregada(s) a su orden!");
                                } else {
                                    System.out.println("-> Porcion extra no encontrada.");
                                }
                            }
                        }

                        showDrinks(menuCtrl);
                        System.out.print("\nQue bebida desea para acompanar su pedido? (Ingrese el ID del 1 al 7, o 0 para ninguna): ");
                        int drinkId = scanner.nextInt();
                        scanner.nextLine();

                        if (drinkId > 0) {
                            Drink chosenDrink = null;
                            for (Drink b : menuCtrl.getDrinksMenu()) {
                                if (b.getId() == drinkId) {
                                    chosenDrink = b;
                                    break;
                                }
                            }

                            if (chosenDrink != null) {
                                System.out.print("Cuantas unidades de " + chosenDrink.getName() + " desea?: ");
                                int drinkQty = scanner.nextInt();
                                scanner.nextLine();
                                if (drinkQty <= 0) drinkQty = 1;

                                Drink orderedDrink = new Drink(chosenDrink, drinkQty);
                                currentOrder.addDrink(orderedDrink);
                                System.out.println("-> " + drinkQty + "x " + chosenDrink.getName() + " agregada(s) a su orden!");
                            } else {
                                System.out.println("-> Bebida no encontrada, se omitio la bebida.");
                            }
                        } else {
                            System.out.println("-> Sin bebida agregada.");
                        }

                        showSides(menuCtrl);
                        int sideId = -1;
                        while (sideId != 0) {
                            System.out.print("\nDesea algun acompanamiento de cortesia? (Ingrese el ID del 1 al 6, o 0 para terminar): ");
                            sideId = scanner.nextInt();
                            scanner.nextLine();

                            if (sideId > 0) {
                                Side chosenSide = null;
                                for (Side s : menuCtrl.getSidesMenu()) {
                                    if (s.getId() == sideId) {
                                        chosenSide = s;
                                        break;
                                    }
                                }

                                if (chosenSide != null) {
                                    System.out.print("Cuantas porciones/sobres de " + chosenSide.getName() + " desea?: ");
                                    int sideQty = scanner.nextInt();
                                    scanner.nextLine();
                                    if (sideQty <= 0) sideQty = 1;

                                    Side orderedSide = new Side(chosenSide, sideQty);
                                    currentOrder.addSide(orderedSide);
                                    System.out.println("-> " + sideQty + "x " + chosenSide.getName() + " agregado(s) a su orden!");
                                } else {
                                    System.out.println("-> Acompanamiento no encontrado.");
                                }
                            }
                        }
                        System.out.println("-> Pedido registrado con exito.");

                    } else {
                        System.out.println("-> Error: Platillo no encontrado.");
                    }
                    break;

                case 3:
                    System.out.println("\n--- RESUMEN DE SU ORDEN (MESA " + currentOrder.getTableNumber() + ") ---");
                    if (currentOrder.getDetails().isEmpty() && currentOrder.getDrinks().isEmpty() && currentOrder.getExtraPortions().isEmpty()) {
                        System.out.println("Su orden esta vacia.");
                    } else {
                        if (!currentOrder.getDetails().isEmpty()) {
                            System.out.println("PLATILLOS:");
                            for (OrderDetail od : currentOrder.getDetails()) {
                                System.out.println("- " + od.toString());
                            }
                        }

                        if (!currentOrder.getExtraPortions().isEmpty()) {
                            System.out.println("\nPORCIONES EXTRA:");
                            for (ExtraPortion ep : currentOrder.getExtraPortions()) {
                                System.out.println("- " + ep.toString());
                            }
                        }
                        
                        if (!currentOrder.getDrinks().isEmpty()) {
                            System.out.println("\nBEBIDAS:");
                            for (Drink b : currentOrder.getDrinks()) {
                                System.out.println("- " + b.toString());
                            }
                        }

                        if (!currentOrder.getSides().isEmpty()) {
                            System.out.println("\nACOMPANAMIENTOS (CORTESIA):");
                            for (Side s : currentOrder.getSides()) {
                                System.out.println("- " + s.toString());
                            }
                        }
                        
                        double subtotal = currentOrder.calculateSubtotal();
                        System.out.println("--------------------------------");
                        System.out.println("Subtotal: $" + String.format("%.2f", subtotal));
                        
                        System.out.print("Desea agregar propina? Ingrese el porcentaje (ej. 10 para 10%, 0 para nada): ");
                        double tipPercentage = scanner.nextDouble();
                        scanner.nextLine();
                        
                        currentOrder.setTip(new Tip(tipPercentage));
                        
                        double tipAmount = currentOrder.getTip().calculateTipAmount(subtotal);
                        System.out.println("Propina (" + tipPercentage + "%): $" + String.format("%.2f", tipAmount));
                        System.out.println("TOTAL A PAGAR: $" + String.format("%.2f", currentOrder.calculateTotal()));
                        
                        FileManager.exportOrderToCSV(currentOrder);
                        
                        System.out.println("\n(Notificando al mesero... Gracias por su compra)");
                        option = 4; 
                    }
                    break;

                case 4:
                    System.out.println("Gracias por visitarnos. Vuelva pronto!");
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }
        }
        scanner.close();
    }

    private static String selectChickenPieces(MenuController menuCtrl, Scanner scanner, int quantity) {
        showChickenPieces(menuCtrl);
        List<String> pieceNamesList = new ArrayList<>();
        
        for (int i = 1; i <= quantity; i++) {
            if (quantity > 1) {
                System.out.print("Que presa de pollo desea para la unidad #" + i + "? (Ingrese numero del 1 al 5): ");
            } else {
                System.out.print("Que presa de pollo desea? (Ingrese numero del 1 al 5): ");
            }
            int pieceId = scanner.nextInt();
            scanner.nextLine();

            ChickenPiece chosenPiece = null;
            for (ChickenPiece cp : menuCtrl.getChickenPiecesMenu()) {
                if (cp.getId() == pieceId) {
                    chosenPiece = cp;
                    break;
                }
            }

            if (chosenPiece != null) {
                pieceNamesList.add(chosenPiece.getName());
                System.out.println("-> Presa seleccionada: " + chosenPiece.getName());
            } else {
                pieceNamesList.add("Pechuga");
                System.out.println("-> Opcion no valida, se asigno Pechuga por defecto.");
            }
        }
        return String.join(", ", pieceNamesList);
    }

    private static void showMenu(MenuController controller) {
        System.out.println("\n--- CATALOGO DE PLATILLOS ---");
        for (Dish d : controller.getMenu()) {
            System.out.println(d.getId() + ". " + d.getName() + " - $" + String.format("%.2f", d.getPrice()));
            System.out.println("   " + d.getDescription());
        }
    }

    private static void showChickenPieces(MenuController controller) {
        System.out.println("\n--- PRESAS DE POLLO DISPONIBLES ---");
        for (ChickenPiece cp : controller.getChickenPiecesMenu()) {
            System.out.println(cp.toString());
        }
    }

    private static void showExtraPortions(MenuController controller) {
        System.out.println("\n--- CATALOGO DE PORCIONES EXTRA ---");
        for (ExtraPortion ep : controller.getExtraPortionsMenu()) {
            System.out.println(ep.getId() + ". " + ep.getName() + " - $" + String.format("%.2f", ep.getPrice()));
        }
    }

    private static void showDrinks(MenuController controller) {
        System.out.println("\n--- CATALOGO DE BEBIDAS ---");
        for (Drink b : controller.getDrinksMenu()) {
            System.out.println(b.getId() + ". " + b.getName() + " - $" + String.format("%.2f", b.getPrice()));
        }
    }

    private static void showSides(MenuController controller) {
        System.out.println("\n--- CATALOGO DE ACOMPANAMIENTOS (CORTESIA) ---");
        for (Side s : controller.getSidesMenu()) {
            System.out.println(s.getId() + ". " + s.getName());
        }
    }
}
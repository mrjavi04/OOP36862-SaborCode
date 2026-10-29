package ec.edu.espe.saborcode.controller;

import ec.edu.espe.saborcode.model.ChickenPiece;
import ec.edu.espe.saborcode.model.Dish;
import ec.edu.espe.saborcode.model.Drink;
import ec.edu.espe.saborcode.model.ExtraPortion;
import ec.edu.espe.saborcode.model.Side;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Javi
 */
public class MenuController {
    private List<Dish> menu;
    private List<Drink> drinksMenu;
    private List<Side> sidesMenu;
    private List<ExtraPortion> extraPortionsMenu;
    private List<ChickenPiece> chickenPiecesMenu;

    public MenuController() {
        this.menu = new ArrayList<>();
        this.drinksMenu = new ArrayList<>();
        this.sidesMenu = new ArrayList<>();
        this.extraPortionsMenu = new ArrayList<>();
        this.chickenPiecesMenu = new ArrayList<>();
        loadInitialMenu();
        loadInitialDrinks();
        loadInitialSides();
        loadInitialExtraPortions();
        loadInitialChickenPieces();
    }

    private void loadInitialMenu() {
        menu.add(new Dish(1, "Parrillada Normal", 2.75, "Presa de pollo, papas chauchas, habas, tostado, ensalada"));
        menu.add(new Dish(2, "Parrillada Mixta de Mollejas", 3.50, "Presa de pollo, mollejas, papas chauchas, habas, tostado, ensalada"));
        menu.add(new Dish(3, "Parrillada Mixta de Embutido", 3.50, "Presa de pollo, chorizo, papas chauchas, habas, tostado, ensalada"));
        menu.add(new Dish(4, "Parrillada Mixta de Patitas", 3.50, "Presa de pollo, patitas, papas chauchas, habas, tostado, ensalada"));
        menu.add(new Dish(5, "Parrillada de Mollejas", 2.75, "Mollejas, papas chauchas, habas, tostado, ensalada"));
        menu.add(new Dish(6, "Parrillada Mixta de Mollejas y Patitas", 3.50, "Mollejas, patitas, papas chauchas, habas, tostado, ensalada"));
        menu.add(new Dish(7, "Parrillada de Patitas", 1.75, "Patitas, papas chauchas, habas, tostado, ensalada"));
        menu.add(new Dish(8, "Habas con Queso", 1.50, "Habas con queso"));
        menu.add(new Dish(9, "Choclo", 1.00, "Choclo con queso"));
        menu.add(new Dish(10, "Platano Asado", 1.00, "Platano asado con queso"));
    }

    private void loadInitialChickenPieces() {
        chickenPiecesMenu.add(new ChickenPiece(1, "Ala"));
        chickenPiecesMenu.add(new ChickenPiece(2, "Pierna"));
        chickenPiecesMenu.add(new ChickenPiece(3, "Pospierna"));
        chickenPiecesMenu.add(new ChickenPiece(4, "Pechuga"));
        chickenPiecesMenu.add(new ChickenPiece(5, "Rabadilla"));
    }

    private void loadInitialDrinks() {
        drinksMenu.add(new Drink(1, "Coca-Cola", 1.50));
        drinksMenu.add(new Drink(2, "Fanta", 1.50));
        drinksMenu.add(new Drink(3, "Sprite", 1.50));
        drinksMenu.add(new Drink(4, "Pepsi", 1.25));
        drinksMenu.add(new Drink(5, "Gallito", 1.00));
        drinksMenu.add(new Drink(6, "Fuze Tea", 1.50));
        drinksMenu.add(new Drink(7, "Colada Morada", 2.50));
    }

    private void loadInitialSides() {
        sidesMenu.add(new Side(1, "Mayonesa"));
        sidesMenu.add(new Side(2, "Sal"));
        sidesMenu.add(new Side(3, "Aji"));
        sidesMenu.add(new Side(4, "Pimienta"));
        sidesMenu.add(new Side(5, "Mostaza"));
        sidesMenu.add(new Side(6, "Salsa de Tomate"));
    }

    private void loadInitialExtraPortions() {
        extraPortionsMenu.add(new ExtraPortion(1, "Papas Chauchas", 1.00));
        extraPortionsMenu.add(new ExtraPortion(2, "Habas", 1.00));
        extraPortionsMenu.add(new ExtraPortion(3, "Tostado", 1.00));
        extraPortionsMenu.add(new ExtraPortion(4, "Ensalada", 1.00));
        extraPortionsMenu.add(new ExtraPortion(5, "Embutido", 1.00));
        extraPortionsMenu.add(new ExtraPortion(6, "Patas de Pollo", 1.00));
        extraPortionsMenu.add(new ExtraPortion(7, "Mollejas", 1.00));
        extraPortionsMenu.add(new ExtraPortion(8, "Presa de Pollo", 2.50));
    }

    public List<Dish> getMenu() { return menu; }
    public List<Drink> getDrinksMenu() { return drinksMenu; }
    public List<Side> getSidesMenu() { return sidesMenu; }
    public List<ExtraPortion> getExtraPortionsMenu() { return extraPortionsMenu; }
    public List<ChickenPiece> getChickenPiecesMenu() { return chickenPiecesMenu; }
}
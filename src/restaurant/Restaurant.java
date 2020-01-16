package restaurant;

import java.util.List;
import java.util.ArrayList;

public class Restaurant {
    public static void main(String[] args) {
        List<MenuItem> basicListOfMenuItems = new ArrayList<MenuItem>();
        basicListOfMenuItems.add(new MenuItem("Classic Burger",
                6,
                "The classic! Quarter-pound patty with standard toppings ketchup, mustard, pickles, & onions.",
                MenuCategory.MAIN_COURSE));
        basicListOfMenuItems.add(new MenuItem("Cuban",
                10,
                "Dry-rubbed, smoked pulled pork, smoked ham, melted Swiss cheese, pickles, and mustard.",
                MenuCategory.MAIN_COURSE));
        basicListOfMenuItems.add(new MenuItem("Grilled Cheese",
                6,
                "Your choice of two cheeses on sourdough: mild cheddar, Irish cheddar, herb goat, Swiss, pepper jack, or American.",
                MenuCategory.MAIN_COURSE));
        basicListOfMenuItems.add(new MenuItem("Nachos",
                10,
                "Freshly-fried tortilla chips smothered in gooey cheddar cheese, grilled onions, seared pulled pork, sour cream, & fresh pico de gallo.",
                MenuCategory.APPETIZER));

        MenuItem singleDessertItem = new MenuItem("Ice Cream",
                4,
                "Cup of vanilla, chocolate, or strawberry ice cream.",
                MenuCategory.DESSERT);

        MenuItem appToRemove = new MenuItem("Nachos",
                10,
                "Freshly-fried tortilla chips smothered in gooey cheddar cheese, grilled onions, seared pulled pork, sour cream, & fresh pico de gallo.",
                MenuCategory.APPETIZER);



        // Create Menu Object
        Menu menu = new Menu(basicListOfMenuItems);
        // Print menu
        System.out.println("\n--------------------------------------");
        System.out.println("Print the menu");
        System.out.println("--------------------------------------\n");
        System.out.print(menu.toString());

        // Print a single item as it would appear in the menu and stand alone
        System.out.println("\n--------------------------------------");
        System.out.println("Print a single item as it would appear in the menu and stand alone");
        System.out.println("--------------------------------------");
        System.out.print(singleDessertItem.toString());
        System.out.println("");
        System.out.print(singleDessertItem.singleUseToString());

        // Add a new item to the menu and print the new menu
        System.out.println("\n--------------------------------------");
        System.out.println("Add a new item to the menu and print the new menu");
        System.out.println("--------------------------------------");
        menu.addMenuItem(singleDessertItem);
        System.out.print(menu.toString());

        // Test MenuItem equals method
        System.out.println("\n--------------------------------------");
        System.out.println("Test MenuItem equals method");
        System.out.println("--------------------------------------");
        System.out.println(appToRemove.equals(menu.getMenuCategory(MenuCategory.APPETIZER).get(0)));

        // Remove a single item from the menu and print the menu
        System.out.println("\n--------------------------------------");
        System.out.println("Remove a single item from the menu and print the menu");
        System.out.println("--------------------------------------");
        menu.removeMenuItem(appToRemove);
        System.out.print(menu.toString());

        // Add a single duplicate item to the menu and print the menu
        System.out.println("\n--------------------------------------");
        System.out.println("Add a single duplicate item to the menu and print the menu");
        System.out.println("--------------------------------------");
        menu.addMenuItem(singleDessertItem);
        System.out.print(menu.toString());

        // Try to add an item from a category which isn't recognized
//        MenuItem badCategoryItem = new MenuItem("Pizza",
//                8,
//                "12 inch cheese pizza.",
//                "Pizza");
//        menu.addMenuItem(badCategoryItem);
//        System.out.print(menu.toString());

    }
}

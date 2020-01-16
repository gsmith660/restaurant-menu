package restaurant;

import java.util.List;
import java.util.ArrayList;

public class Restaurant {
    public static void main(String[] args) {
        List<MenuItem> basicListOfMenuItems = new ArrayList<MenuItem>();
        basicListOfMenuItems.add(new MenuItem("Classic Burger",
                6,
                "The classic! Quarter-pound patty with standard toppings ketchup, mustard, pickles, & onions.",
                "main course"));
        basicListOfMenuItems.add(new MenuItem("Cuban",
                10,
                "Dry-rubbed, smoked pulled pork, smoked ham, melted Swiss cheese, pickles, and mustard.",
                "main course"));
        basicListOfMenuItems.add(new MenuItem("Grilled Cheese",
                6,
                "Your choice of two cheeses on sourdough: mild cheddar, Irish cheddar, herb goat, Swiss, pepper jack, or American.",
                "main course"));
        basicListOfMenuItems.add(new MenuItem("Nachos",
                10,
                "Freshly-fried tortilla chips smothered in gooey cheddar cheese, grilled onions, seared pulled pork, sour cream, & fresh pico de gallo.",
                "appetizer"));

        MenuItem singleDessertItem = new MenuItem("Ice Cream",
                4,
                "Cup of vanilla, chocolate, or strawberry ice cream.",
                "dessert");

        MenuItem appToRemove = new MenuItem("Nachos",
                10,
                "Freshly-fried tortilla chips smothered in gooey cheddar cheese, grilled onions, seared pulled pork, sour cream, & fresh pico de gallo.",
                "appetizer");




        Menu menu = new Menu(basicListOfMenuItems);
//        System.out.println(menu.getDateLastModified());
//        System.out.print(menu.toString());

//        System.out.println("--------------------------------------");
//        System.out.print(singleDessertItem.toString());
//        System.out.println("");
//        System.out.print(singleDessertItem.singleUseToString());

//        System.out.println("--------------------------------------");
        menu.addMenuItem(singleDessertItem);
//        System.out.println(menu.getDateLastModified());
//        System.out.print(menu.toString());

//        System.out.println(appToRemove.equals(menu.getMenuCategory("appetizer").get(0)));
        menu.removeMenuItem(appToRemove);
        System.out.print(menu.toString());

    }
}

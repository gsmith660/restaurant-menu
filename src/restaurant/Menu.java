package restaurant;

import java.util.*;

public class Menu {
    private Date dateLastModified;
    private Map<String, List<MenuItem>> menuData = new HashMap<>();
    private int newAgeInDays = 14;

    // Constructors
    public Menu(List<MenuItem> items) {
        for (MenuItem item : items) {
            addMenuItem(item);
        }
    }


    // Setters
    public void addMenuItem(MenuItem item) {
        String categoryKey = item.getCategory();
        if (menuData.containsKey(categoryKey)) {
            if (!menuData.get(categoryKey).contains(item)) {
                menuData.get(categoryKey).add(item);
            } else {
                System.out.println("The " + item.getName() + " item is already on the menu.");
            }
        } else {
            List<MenuItem> newList = new ArrayList<>();
            newList.add(item);
            menuData.put(categoryKey, newList);
        }
        this.dateLastModified = new Date();
    }

    public boolean removeMenuItem(MenuItem item) {
        String categoryKey = item.getCategory();
        boolean itemWasRemoved = menuData.get(categoryKey).remove(item);
        if (itemWasRemoved) {
            if (menuData.get(categoryKey).isEmpty()) {
                menuData.remove(categoryKey);
            }
            this.dateLastModified = new Date();
        }
        return itemWasRemoved;
    }

    private void updateNewStatus() {
        for (Map.Entry<String, List<MenuItem>> entry : menuData.entrySet()) {
            for (MenuItem item : entry.getValue()) {
                if (Math.abs(item.getDateCreated().getTime() - this.dateLastModified.getTime()) < newAgeInDays * 24 * 60 * 60 * 1000) {
                    item.setIsNew(true);
                } else {
                    item.setIsNew(false);
                }
            }
        }
    }


    // Getters
    public Date getDateLastModified() {
        return dateLastModified;
    }

    public int getNewAgeInDays() {
        return newAgeInDays;
    }

    public Set<String> getCategories() {
        return menuData.keySet();
    }

    public Map<String, List<MenuItem>> getMenuData() {
        updateNewStatus();
        return menuData;
    }

    public List<MenuItem> getMenuCategory(String category) {
        updateNewStatus();
        return menuData.get(category);
    }

    // toString
    @Override
    public String toString() {
        String output = "";
        for (String categoryKey : menuData.keySet()) {
            output += "\n" + "********************" + "\n" +
                    categoryKey + "\n" +
                    "********************";
            for (MenuItem item : menuData.get(categoryKey)) {
                output += "\n" + "*****" + "\n" + item.toString() + "*****" + "\n";
            }
        }
        return output;
    }
}

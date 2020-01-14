package restaurant;

import java.util.*;

public class Menu {
    private Date dateLastModified;
    private Map<String, List<MenuItem>> menuData;

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
            menuData.get(categoryKey).add(item);
        } else {
            List<MenuItem> newList = new ArrayList<>();
            newList.add(item);
            menuData.put(categoryKey, newList);
        }
        this.dateLastModified = new Date();
        updateNewStatus();
    }

    public boolean removeMenuItem(MenuItem item) {
        String categoryKey = item.getCategory();
        boolean itemWasRemoved = menuData.get(categoryKey).remove(item);
        if (itemWasRemoved) {
            if (menuData.get(categoryKey).isEmpty()) {
                menuData.remove(categoryKey);
            }
            this.dateLastModified = new Date();
            updateNewStatus();
        }
        return itemWasRemoved;
    }

    private void updateNewStatus() {
        for (Map.Entry<String, List<MenuItem>> entry : menuData.entrySet()) {
            for (MenuItem item : entry.getValue()) {
                if (item.getDateLastModified().getTime() - this.dateLastModified.getTime() < 14 * 24 * 60 * 60 *1000) {
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

    public Map<String, List<MenuItem>> getMenuData() {
        return menuData;
    }

    public Set<String> getCategories() {
        return menuData.keySet();
    }

    public List<MenuItem> getMenuCategory(String category) {
        return menuData.get(category);
    }
}

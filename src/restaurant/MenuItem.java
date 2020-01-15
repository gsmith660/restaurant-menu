package restaurant;

import java.util.Date;
import java.util.Objects;

public class MenuItem {
    private double price;
    private String description;
    private String category;
    private boolean isNew;

    private String name;
    private Date dateCreated;

    // Constructors
    public MenuItem(String name, double price, String description, String category) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
        this.dateCreated = new Date();
        this.isNew = true;
    }

    // Setters
    public void setPrice(double price) {
        this.price = price;
    }
    public void setIsNew(boolean newValue) {
        this.isNew = newValue;
    }

    // Getters
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public String getDescription() {
        return description;
    }
    public String getCategory() {
        return category;
    }
    public Date getDateCreated() {
        return dateCreated;
    }
    public boolean getIsNew() {
        return isNew;
    }


    // equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuItem menuItem = (MenuItem) o;
        return description.equals(menuItem.description) &&
                category.equals(menuItem.category) &&
                name.equals(menuItem.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, category, name);
    }


    // toString
    @Override
    public String toString() {
        String newMessage = "";
        if (isNew) {
            newMessage = "New Item!\n";
        }
        return newMessage +
                "Name: " + name + "\n" +
                "Description: " + description + "\n" +
                "Price: " + price + "\n";
    }

    public String singleUseToString() {
        return toString() +
                "Category: " + category + "\n";
    }
}

package restaurant;

import java.util.Date;

public class MenuItem {
    private double price;
    private String description;
    private String category;
    private boolean isNew;

    private Date dateLastModified;

    // Constructors
    public MenuItem(double price, String description, String category) {
        this.price = price;
        this.description = description;
        this.category = category;
        this.dateLastModified = new Date();
        this.isNew = true;
    }

    // Setters
    public void setPrice(double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
        this.dateLastModified = new Date();
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setIsNew(boolean isNew) {
        this.isNew = isNew;
    }

    // Getters
    public double getPrice() {
        return price;
    }
    public String getDescription() {
        return description;
    }
    public String getCategory() {
        return category;
    }
    public Date getDateLastModified() {
        return dateLastModified;
    }
    public boolean getIsNew() {
        return isNew;
    }
}

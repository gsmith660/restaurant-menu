package restaurant;

public enum MenuCategory {
    APPETIZER("Appetizer"),
    MAIN_COURSE("Main Course"),
    DESSERT("Dessert");

    private final String displayName;

    MenuCategory (String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return this.displayName;
    }
}

package teme.w06_collections.ex1_building_registry;

enum Category {
    RESIDENTIAL, OFFICE, HOSPITAL, RELIGIOUS
}

public class Building {
    private Category category;
    private int price;
    private String neighborhood;

    public Category getCategory() {
        return category;
    }

    public int getPrice() {
        return price;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public Building(Category category, int price, String neighborhood) {
        this.category = category;
        this.price = price;
        this.neighborhood = neighborhood;
    }
}


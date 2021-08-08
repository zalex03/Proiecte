package teme.w05_oop2.ex2_cart.product;

public class Product {
    int id;
    private String name;
    private String type;
    private double price;
    private String color;
    private double totalPrice;

    public Product(int id, String name, String type, double price, String color) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.color = color;

    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                ", totalPrice=" + totalPrice +
                '}';
    }//
}

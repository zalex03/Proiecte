package teme.w05_oop2.ex2_cart;

import teme.w05_oop2.ex2_cart.customer.Customer;
import teme.w05_oop2.ex2_cart.discount.Discount;
import teme.w05_oop2.ex2_cart.product.Product;

import java.util.ArrayList;

public class Cart {

    public Cart() {
    }

    int i = 0;
    int j = 0;
    //must be static to avoid losing its value after loop
    double productPrice = 0.0;
    private static double totalPrice;
    String customer;
    public ArrayList<Product> products = new ArrayList<>();
    public ArrayList<Discount> discount = new ArrayList<>();


    public Cart(Customer customer) {
    }

    void addProduct(Product p) {
        products.add(p);
    }

    void removeProduct(Product p) {
        products.remove(p);
        productPrice -= p.getPrice();
    }


    void addDiscount(Discount d) {
        discount.add(d);
    }

    void removeDiscount(Discount d) {
        discount.remove(d);
        totalPrice = d.discount();

    }


    //double computeProductsPrice(){}
    public double computeProductsPrice() {
        if (products.isEmpty()) {
            return 0.0;
        }
        for (; i < products.size(); ) {
            productPrice += products.get(i).getPrice();
            i++;
        }
        totalPrice = productPrice;
        return productPrice;
    }


    double computeTotalPrice() {
       /* if (products.isEmpty()) {
            return 0.0;
        }

        for (; i < products.size(); ) {
            productPrice += products.get(i).getPrice();
            i++;
        }*/
        if (discount.isEmpty()) {
            return computeProductsPrice();
        }

        for (; j < discount.size(); ) {

            totalPrice = discount.get(j).discount();
            j++;
        }

        return totalPrice;
        //discount.get(discount.size() - 1).discount();
    }


    public double getProductPrice() {
        return productPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }


    String generateInvoice() {
        return "" + Cart.totalPrice + getProductPrice();
    }

    @Override
    public String toString() {
        return "Cart{" +
                "products=" + products +
                '}';
    }
}

package teme.w05_oop2.ex2_cart.discount;

import teme.w05_oop2.ex2_cart.Cart;

public class FixedDiscount extends Discount {
    private double amount;
    Cart cart = new Cart();

    public FixedDiscount(double amount) {
        this.amount = amount;
    }

    public double getValue() {
        return amount;
    }

    @Override
    public double discount() {
        // System.out.println(getAmount());
        //System.out.println(cart.computeProductsPrice());
        if (getValue() > cart.getTotalPrice()) {
            return 0.0;
        }


        return cart.getTotalPrice() - getValue();
    }

    @Override
    public String toString() {
        return "FixedDiscount{" +
                "amount=" + amount +
                '}';
    }
}

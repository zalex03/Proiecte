package teme.w05_oop2.ex2_cart.discount;

import teme.w05_oop2.ex2_cart.Cart;

public class PercentageDiscount extends Discount {
    private int percent;
    Cart cart = new Cart(); // avoiding null

    public PercentageDiscount(int percent) {
        this.percent = percent;
    }

    public double getValue() {
        return percent;
    }

    @Override
    public double discount() {


        return cart.getTotalPrice() - cart.getTotalPrice() * getValue() / 100;
    }

    @Override
    public String toString() {
        return "PercentageDiscount{" +
                "percent=" + percent +
                '}';
    }//
}

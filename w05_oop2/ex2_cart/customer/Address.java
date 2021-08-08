package teme.w05_oop2.ex2_cart.customer;

public class Address {
    String street;
    int streetNumber;
    String town;

    public Address(String street, int streetNumber, String town) {
        this.street = street;
        this.streetNumber = streetNumber;
        this.town = town;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", streetNumber=" + streetNumber +
                ", town='" + town + '\'' +
                '}';
    }//
}



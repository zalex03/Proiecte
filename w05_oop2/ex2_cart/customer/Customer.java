package teme.w05_oop2.ex2_cart.customer;

public class Customer {
    String firstName;
    String lastName;
    String cnp;
    Address address;

    public Customer(String firstName, String lastName, String cnp, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cnp = cnp;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cnp='" + cnp + '\'' +
                ", address=" + address +
                '}';
    }//
}

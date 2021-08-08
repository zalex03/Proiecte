package teme.w05_oop2.ex3_complex;

class Complex {
    double realNumber;
    double imaginaryNumber;

    public Complex(double realNumber, double imaginaryNumber) {
        this.realNumber = realNumber;
        this.imaginaryNumber = imaginaryNumber;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) return false;
        if (other instanceof Complex && this.realNumber == ((Complex) other).realNumber &&
                this.imaginaryNumber == ((Complex) other).imaginaryNumber) {
            return true;
        }
        return false;
    }


    @Override
    public String toString() {
        return "" + realNumber + " + " + imaginaryNumber + "i";
    }

    static Complex complex(double real, double imaginary) {
        return new Complex(real, imaginary);
    }

    Complex add(Complex other) {
        return new Complex(this.realNumber + other.realNumber, this.imaginaryNumber + other.imaginaryNumber);
    }

    Complex negate() {
        return new Complex(this.realNumber * -1, this.imaginaryNumber * -1);
    }

    Complex multiply(Complex other) {
        return new Complex((this.realNumber * other.realNumber) - (this.imaginaryNumber * other.imaginaryNumber),
                (this.realNumber * other.imaginaryNumber) + (this.imaginaryNumber * other.realNumber));
    }

    //TODO: add your code here...


    /**
     * Added just for running some manual tests
     */
    public static void main(String[] args) {

        //TODO: you may uncomment/run this once you fill in the contents of Complex class

        Complex c1 = complex(1, 2);
        Complex c2 = complex(3, 4);

        //manual testing
        System.out.println("c1: " + c1 + ", c2: " + c2);
        System.out.println("!c1 = " + c1.negate());
        System.out.println("c1+c2 = " + c1.add(c2));
        System.out.println("c1*c2 = " + c1.multiply(c2));

    }
}

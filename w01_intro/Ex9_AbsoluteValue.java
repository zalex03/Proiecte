package teme.w01_intro;

class Ex9_AbsoluteValue {

    /**
     * @param x some numbe
     * @return the absolute value of x (value without the sign)
     */
    static double abs(double x) {

        return x > 0 ? x : x * -1;
    }

    public static void main(String[] args) {
        System.out.println(abs(3.2));  //should be: 3.2
        System.out.println(abs(0));    //should be: 0.0
        System.out.println(abs(-7));   //should be: 7.0
    }
}

package teme.w01_intro;

class Ex4_EvenOddChecker {

    /**
     * Checks a given integer number if is even or odd
     *
     * @param n number to check, valid interval 1..1000
     * @return 0 if number is even, 1 if it's odd, or -1 if outside valid interval
     */
    static int convertEvenOddToZeroOne(int n) {
        int numberCheck = n % 2;
        return (n > 0 && n <= 1000) ? numberCheck : -1;
    }

    /**
     * Checks a given integer number if is even or odd
     *
     * @param n a number to check, valid inteval 1..1000
     * @return "even" if number is even, "odd" if it's odd, or "invalid" if outside valid interval
     */
    static String convertEvenOddToString(int n) {
        int numberChecker = n % 2;
        String evenOdd = numberChecker == 0 ? "even" : "odd";
        return (n > 0 && n <= 1000) ? evenOdd : "invalid";

    }

    //manual tests
    public static void main(String[] args) {
        System.out.println(convertEvenOddToZeroOne(3));
        System.out.println(convertEvenOddToZeroOne(4));
        System.out.println(convertEvenOddToZeroOne(-9_999));

        System.out.println(convertEvenOddToString(3));
        System.out.println(convertEvenOddToString(4));
        System.out.println(convertEvenOddToString(100_000));
    }
}

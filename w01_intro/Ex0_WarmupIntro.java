package teme.w01_intro;

class Ex0_WarmupIntro {

    static int computeSum(int a, int b) {

        return a + b;
    }


    static double squareValue(double x) {

        return x * x;
    }

    static String joinStrings(String s1, String s2) {

        return s1 + s2;
    }

    static int lengthOf(String s) {
        return s.length();
    }

    static int truncate(double x) {

        return (int) x;
    }

    static boolean isInInterval(int x, int min, int max) {
        return x <= max && x >= min;


    }

    static boolean sameLength(String s1, String s2) {
        return s1.length() == s2.length();
    }

    /**
     * Main method, we use here just for easy manual testing of our methods above.
     * NOTE: after manual test run ok, don't forget to also run the automatic tests, see Ex0_Tests class!
     */
    public static void main(String[] args) {
        System.out.println("sum(2,3) = " + computeSum(2, 3));
        System.out.println("square(3) = " + squareValue(3));
        System.out.println("joinStrings('ab', 'cd') = '" + joinStrings("ab", "cd") + "'");
        System.out.println("lengthOf('abc') = " + lengthOf("abc"));
        System.out.println("truncate(3.21) = " + truncate(3.21));
        System.out.println("isInInterval(3, 0, 5) = " + isInInterval(3, 0, 5));
        System.out.println("isInInterval(3, 5, 10) = " + isInInterval(3, 5, 10));
        System.out.println("sameLength('abc', '123') = " + sameLength("abc", "123"));
        System.out.println("sameLength('ab', '1234') = " + sameLength("ab", "1234"));
    }
}

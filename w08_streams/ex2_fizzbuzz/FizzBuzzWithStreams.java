package teme.w08_streams.ex2_fizzbuzz;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class FizzBuzzWithStreams {

    /**
     * Helper method translating ONE number to a single fizzbuzz value.
     * Ok to use regular code here (if-else..)
     * Then use this method in both imperative and stream methods below.
     */
    static String toFizzBuzz(int i) {
        if (i % 15 == 0) {
            return "fizzbuzz";
        } else if (i % 3 == 0) {
            return "fizz";
        } else if (i % 5 == 0) {
            return "buzz";
        }
        return "" + i;
    }

    /**
     * Method going over numbers 1..n and printing the fizzbuzz value for each.
     * <p>
     * Iterative version, may use loops, etc..
     */
    //am inteles cum se fac cu streamul abea dupa ce am introdus toFizzBuzz aici
    static void fizzBuzzImperative(int n) {
        List<String> holdAll = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            holdAll.add(toFizzBuzz(i));

        }
        System.out.println(holdAll.toString().replace("[", "").replace("]", ""));
    }


    /**
     * Method going over numbers 1..n and printing the fizzbuzz value for each.
     * <p>
     * Functional version, should not use any explicit loops, but only streams operations.
     * <p>
     * Hint: read about IntStream.rangeClosed() method, and streams of primitives..
     */
    static void fizzBuzzWithStreams(int n) {
        List<String> holdAll = new ArrayList<>();
        IntStream.rangeClosed(1, n).forEach(i -> holdAll.add(toFizzBuzz(i)));
        System.out.println(holdAll.toString().replace("[", "").replace("]", ""));

    }

    /**
     * Some manual tests
     */
    public static void main(String[] args) {
        System.out.println("fizzbuzz(6) = " + toFizzBuzz(6));
        System.out.println("fizzbuzz(7) = " + toFizzBuzz(7));
        System.out.println("fizzbuzz(20) = " + toFizzBuzz(20));
        System.out.println("fizzbuzz(30) = " + toFizzBuzz(30));

        System.out.println("\nFizzBuzz up to 30 (imperative):");
        fizzBuzzImperative(30);

        System.out.println("\nFizzBuzz up to 30 (streams):");
        fizzBuzzWithStreams(30);
    }
}

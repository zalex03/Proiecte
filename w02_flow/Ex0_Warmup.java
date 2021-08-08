package teme.w02_flow;

import java.util.Arrays;

class Ex0_Warmup {

    static String xTimes(String s, int n) {
        String res = "";
        for (int i = 1; i <= n; i++) {
            res += s;
        }

        return res;

    }

    static int sumSquares(int n) {
        int i;
        int s = 0;
        for (i = 1; i <= n; i++) {
            s += i * i;
        }
        return s;
    }


    static long factorial(int n) {

        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    static long factorialRec(int n) {
        if (n <= 1) { //stop condition
            return 1;
        } else { //recursive case (n is != 1)
            return n * factorialRec(n - 1);
        }
    }


    static byte dayOfWeek(String s) {
        // needed one more variable for storing the result
        byte day = -1;
        switch (s.toLowerCase()) {
            case "luni":
                day = 1;
                System.out.println(day);
                break;
            case "marti":
                day = 2;
                System.out.println(day);
                break;
            case "miercuri":
                day = 3;
                System.out.println(day);
                break;
            case "joi":
                day = 4;
                System.out.println(day);
                break;
            case "vineri":
                day = 5;
                System.out.println(day);
                break;
            case "sambata":
                day = 6;
                System.out.println(day);
                break;
            case "duminica":
                day = 7;
                System.out.println(7);
                break;
            default:
                System.out.println(day);
        }
        return day;
    }


    static double sum(double[] arr) {
        double s = 0;

        for (int i = 0; i < arr.length; i++) {
            System.out.println("here" + i);
            s += arr[i];

        }
        return s;
    }

    static double avg(double[] arr) {
        double s = 0;
        for (double i = 0; i < arr.length; i++) {
            s = i + 1;
        }

        return sum(arr) / s;
    }

    static double max(double[] arr) {

        if (arr.length == 0) {
            return Double.NEGATIVE_INFINITY;
        } else {
            double maxValue = arr[0];
            for (int i = 0; i <= arr.length - 1; i++) {
                if (maxValue <= arr[i])
                    maxValue = arr[i];

            }

            return maxValue;
        }
    }


    static double sumPositives(double[] arr) {


        double s = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                s += arr[i];

            } else {
                break;
            }

        }

        return s;
    }


    static void multiply(double[] arr, double x) {
        double multiply = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] *= x;

        }
        return;
    }


    public static void main(String[] args) {
        System.out.println("xTimes('abc',2)= '" + xTimes("abc", 2) + "'");
        System.out.println("sumSquares(4)= " + sumSquares(4));

        System.out.println("\ndayOfWeek('luni') = " + dayOfWeek("luni"));
        System.out.println("dayOfWeek('DUMINICA') = " + dayOfWeek("DUMINICA"));
        System.out.println("dayOfWeek('invalid') = " + dayOfWeek("invalid"));

        System.out.println("\nfactorial(1) = " + factorial(1));
        System.out.println("factorial(5) = " + factorial(5));
        System.out.println("factorial(13) = " + factorial(13));
        System.out.println("factorialRec(1) = " + factorialRec(1));
        System.out.println("factorialRec(5) = " + factorialRec(5));
        System.out.println("factorialRec(13) = " + factorialRec(13));

        double[] values1 = {1.1, 2.2, 3.3, 4.4};
        System.out.println("\nsum(" + Arrays.toString(values1) + ") = " + sum(values1));
        System.out.println("avg(" + Arrays.toString(values1) + ") = " + avg(values1));
        System.out.println("max(" + Arrays.toString(values1) + ") = " + max(values1));

        double[] values2 = {}; //an empty array
        System.out.println("\nsum(" + Arrays.toString(values2) + ") = " + sum(values2));
        System.out.println("avg(" + Arrays.toString(values2) + ") = " + avg(values2));
        System.out.println("max(" + Arrays.toString(values2) + ") = " + max(values2));

        double[] values3 = {1, 2, 3, -4, 5, 6};
        System.out.println("\nsumPositives(" + Arrays.toString(values3) + ") = " + sumPositives(values3));

        System.out.println("\ninitial array: " + Arrays.toString(values3));
        multiply(values3, 10);
        System.out.println("array after calling multiply() with factor 10: " + Arrays.toString(values3));
    }
}

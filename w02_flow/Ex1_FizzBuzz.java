package teme.w02_flow;

class Ex1_FizzBuzz {

    static String fizzBuzz(int i) {
        if (i % 3 == 0 && i % 5 == 0) {
            return "fizzbuzz";
        } else if (i % 5 == 0) {
            return "buzz";
        } else if (i % 3 == 0) {
            return "fizz";
        }
        return String.valueOf(i);
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 20; i++) {
            System.out.println(i + " => " + fizzBuzz(i));
        }
    }
}

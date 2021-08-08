package teme.w01_intro;

class Ex6_DigitRemover {

    static int removeMiddleDigit(int n) {
        String s = String.valueOf(n);
        String fiveDigitNumberStart = (s.length() == 5) ? s.substring(0, 2) + s.substring(3, 5) : "-1";


        return Integer.valueOf(fiveDigitNumberStart);
    }

    //manual tests
    public static void main(String[] args) {
        //invalid:
        System.out.println(removeMiddleDigit(123));
        System.out.println(removeMiddleDigit(-12345));
        System.out.println(removeMiddleDigit(9999));
        System.out.println(removeMiddleDigit(100000));
        //valid:
        System.out.println(removeMiddleDigit(12345));
    }
}

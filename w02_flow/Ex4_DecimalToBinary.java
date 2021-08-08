package teme.w02_flow;

class Ex4_DecimalToBinary {

    static String decimalToBinary(int n) {
        StringBuilder result = new StringBuilder();


        int[] binaryCode = new int[1000];
        int i = 0;
        if (n == 0) {
            return "0";
        }
        while (n > 0) {
            binaryCode[i] = n % 2;
            i++;
            n = n / 2;
        }
        for (int j = i - 1; j >= 0; j--) {
            /* */
            result.append(binaryCode[j]);

        }


        return result.toString();
    }

    /**
     * Just for manual testing
     */
    public static void main(String[] args) {
        System.out.println(decimalToBinary(0));
        System.out.println(decimalToBinary(1));
        System.out.println(decimalToBinary(2));
        System.out.println(decimalToBinary(3));
        System.out.println(decimalToBinary(4));
        System.out.println(decimalToBinary(10));
    }
}

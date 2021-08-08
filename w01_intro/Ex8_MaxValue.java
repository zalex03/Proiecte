package teme.w01_intro;

class Ex8_MaxValue {

    static int max(int x, int y) {
        int maxValue = x > y ? x : y;
        return maxValue;
    }

    public static void main(String[] args) {
        System.out.println(max(2, 3));   //should b: 3
        System.out.println(max(-2, -3)); //should be: -2
        System.out.println(max(7, 7));   //should be: 7
    }
}

package teme.w02_flow;

class Ex3_FinancialSimulation {

    static int simulate(double initial, double interestPct, double target) {
        double totalAmount = initial;
        double year = 0;
        double valueOFInterest;
        System.out.printf("\nSimulation started, with parameters: initial: %.2f, interest: %.2f%%, target: %.2f\n",
                initial, interestPct, target);
        while (totalAmount < target) {
            valueOFInterest = initial * interestPct / 100;
            totalAmount = initial + valueOFInterest;
            initial = totalAmount;
            year++;
            System.out.printf("\nYear: %.0f  Value of interest: %.2f => Total amount: %.2f\n", year, valueOFInterest, totalAmount);

        }


        return (int) year;
    }

    public static void main(String[] args) {
        simulate(1000, 10, 900);
        simulate(1000, 10, 1000);
        simulate(1000, 10, 1100);
        simulate(1000, 10, 1600);

        simulate(1000, 2.5, 1500);
        simulate(1000, 0.1, 1500);
    }
}

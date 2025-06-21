public class Finance {
    static double predict(double current, double rate, int years) {
        if (years <= 0) return current;
        return predict(current * (1 + rate/100), rate, years-1);
    }
    
    public static void main(String[] args) {
        double result = predict(1000, 5, 3); // $1000 at 5% for 3 years
        System.out.printf("Future value: $%.2f", result);
    }
}
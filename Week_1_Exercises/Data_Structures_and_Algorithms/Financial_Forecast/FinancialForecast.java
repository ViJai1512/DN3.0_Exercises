public class FinancialForecast {

    public static double predictFutureValue(double presentValue, double growthRate, int periods) {
        if (periods == 0) {
            return presentValue;
        } else {
            return predictFutureValue(presentValue * (1 + growthRate), growthRate, periods - 1);
        }
    }

    public static void main(String[] args) {
        double initialInvestment = 1000.0;
        double annualGrowthRate = 0.05; 
        int years = 5;

        double futureValue = predictFutureValue(initialInvestment, annualGrowthRate, years);
        System.out.println("Future value after " + years + " years: " + futureValue);
    }

public static double predictFutureValueIterative(double presentValue, double growthRate, int periods) {
    for (int i = 0; i < periods; i++) {
        presentValue *= (1 + growthRate);
    }
    return presentValue;
}
}


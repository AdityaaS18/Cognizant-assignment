package Week1DSA.FinancialForecaster;

public class FinancialForecaster {
    public static double calculateFutureValue(double presentValue, double growthRate, int periods) {
        // Base case: if there are no more periods, return the present value
        if (periods == 0) {
            return presentValue;
        }
        
        // Recursive case: calculate the future value for the next period
        double futureValue = presentValue * (1 + growthRate);
        return calculateFutureValue(futureValue, growthRate, periods - 1);
    }
}
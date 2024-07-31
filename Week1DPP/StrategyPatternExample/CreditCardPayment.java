package Week1DPP.StrategyPatternExample;

// CreditCardPayment.java
public class CreditCardPayment implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Paying $" + amount + " using Credit Card");
    }
}

// PayPalPayment.java
class PayPalPayment implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Paying $" + amount + " using PayPal");
    }
}

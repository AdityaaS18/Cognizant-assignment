package Week1DPP.AdapterPatternExample;

// PaymentProcessorTest.java
public class PaymentProcessorTest {
    public static void main(String[] args) {
        PaymentProcessor paypalProcessor = new PayPalAdapter();
        paypalProcessor.processPayment("Payment details for PayPal");

        PaymentProcessor stripeProcessor = new StripeAdapter();
        stripeProcessor.processPayment("Payment details for Stripe");

        PaymentProcessor bankTransferProcessor = new BankTransferAdapter();
        bankTransferProcessor.processPayment("Payment details for Bank Transfer");
    }
}

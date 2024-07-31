package Week1DPP.AdapterPatternExample;

public class StripeGateway {
    public void chargeCard(String paymentDetails) {
        System.out.println("Processing payment through Stripe: " + paymentDetails);
    }
}
package Week1DPP.AdapterPatternExample;

public class PayPalGateway {
    public void makePayment(String paymentDetails) {
        System.out.println("Processing payment through PayPal: " + paymentDetails);
    }
}
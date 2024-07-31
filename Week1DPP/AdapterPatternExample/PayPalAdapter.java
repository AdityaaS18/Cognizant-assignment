package Week1DPP.AdapterPatternExample;


public class PayPalAdapter implements PaymentProcessor {
    private PayPalGateway paypalGateway;

    public PayPalAdapter() {
        this.paypalGateway = new PayPalGateway();
    }

    @Override
    public void processPayment(String paymentDetails) {
        paypalGateway.makePayment(paymentDetails);
    }
}

class StripeAdapter implements PaymentProcessor {
    private StripeGateway stripeGateway;

    public StripeAdapter() {
        this.stripeGateway = new StripeGateway();
    }

    @Override
    public void processPayment(String paymentDetails) {
        stripeGateway.chargeCard(paymentDetails);
    }
}

class BankTransferAdapter implements PaymentProcessor {
    private BankTransferGateway bankTransferGateway;

    public BankTransferAdapter() {
        this.bankTransferGateway = new BankTransferGateway();
    }

    @Override
    public void processPayment(String paymentDetails) {
        bankTransferGateway.transferFunds(paymentDetails);
    }
}

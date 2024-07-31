package Week1DPP.AdapterPatternExample;

public class BankTransferGateway {
    public void transferFunds(String paymentDetails) {
        System.out.println("Processing payment through Bank Transfer: " + paymentDetails);
    }
}
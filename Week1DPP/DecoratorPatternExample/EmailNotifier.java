package Week1DPP.DecoratorPatternExample;

// Implement Concrete Component
public class EmailNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Sending email: " + message);
    }
}

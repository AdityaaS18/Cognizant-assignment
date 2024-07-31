package Week1DPP.DecoratorPatternExample;

// Test the Decorator implementation
public class DecoratorPatternExample {
    public static void main(String[] args) {
        Notifier notifier = new EmailNotifier();
        notifier = new SMSNotifierDecorator(notifier);
        notifier = new SlackNotifierDecorator(notifier);

        notifier.send("Hello, this is a notification!");
    }
}
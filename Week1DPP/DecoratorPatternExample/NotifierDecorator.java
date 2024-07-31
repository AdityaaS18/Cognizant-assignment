package Week1DPP.DecoratorPatternExample;

// Implement abstract decorator class
public abstract class NotifierDecorator implements Notifier {
    private Notifier notifier;

    public NotifierDecorator(Notifier notifier) {
        this.notifier = notifier;
    }

    @Override
    public void send(String message) {
        notifier.send(message);
    }
}
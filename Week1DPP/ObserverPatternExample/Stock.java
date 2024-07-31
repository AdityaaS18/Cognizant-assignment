package Week1DPP.ObserverPatternExample;

// Define Subject Interface
public interface Stock {
    void registerObserver(Observer observer);
    void deregisterObserver(Observer observer);
    void notifyObservers(String stockPrice);
}

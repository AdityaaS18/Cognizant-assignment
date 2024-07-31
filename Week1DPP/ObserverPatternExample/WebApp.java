package Week1DPP.ObserverPatternExample;

// Implement Concrete Observer
public class WebApp implements Observer {
    @Override
    public void update(String stockPrice) {
        System.out.println("Web App: Stock price updated to " + stockPrice);
    }
}

package Week1DPP.ObserverPatternExample;

// Test the Observer Implementation
public class TestObserverPattern {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        MobileApp mobileApp = new MobileApp();
        WebApp webApp = new WebApp();

        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        stockMarket.setStockPrice("100.00");

        stockMarket.deregisterObserver(mobileApp);

        stockMarket.setStockPrice("120.00");
    }
}

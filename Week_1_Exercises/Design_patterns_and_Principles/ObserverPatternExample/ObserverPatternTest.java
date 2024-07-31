public class ObserverPatternTest {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobileApp = new MobileApp("MobileApp");
        Observer webApp = new WebApp("WebApp");

        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        stockMarket.setStockPrice(6989.22);
        stockMarket.setStockPrice(552.75);

        stockMarket.deregisterObserver(mobileApp);

        stockMarket.setStockPrice(100.00);
    }
}

public class TestAdapterPattern {
    public static void main(String[] args) {
        PaymentProcessor payPalProcessor = new PayPalAdapter(new PayPalGateway());
        payPalProcessor.processPayment(100.0);

    }
}

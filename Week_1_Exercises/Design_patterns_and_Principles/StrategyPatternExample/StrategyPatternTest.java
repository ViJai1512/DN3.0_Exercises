public class StrategyPatternTest {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        context.setPaymentStrategy(new CreditCardPayment("1234-5678-9876-5432"));
        context.executePayment(2500.00);

        context.setPaymentStrategy(new PayPalPayment("cognizant@example.com"));
        context.executePayment(1200.00);
    }
}

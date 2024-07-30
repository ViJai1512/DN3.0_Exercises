public class TestDecoratorPattern {
    public static void main(String[] args) {
        Notifier notifier = new EmailNotifier();
        System.out.println("Sending with only EmailNotifier:");
        notifier.send("Hello, this is a test message!");

        Notifier smsNotifier = new SMSNotifierDecorator(new EmailNotifier());
        System.out.println("\nSending with EmailNotifier and SMSNotifierDecorator:");
        smsNotifier.send("Hello, this is a test message!");

        Notifier slackNotifier = new SlackNotifierDecorator(new EmailNotifier());
        System.out.println("\nSending with EmailNotifier and SlackNotifierDecorator:");
        slackNotifier.send("Hello, this is a test message!");

        Notifier allNotifier = new SlackNotifierDecorator(new SMSNotifierDecorator(new EmailNotifier()));
        System.out.println("\nSending with EmailNotifier, SMSNotifierDecorator, and SlackNotifierDecorator:");
        allNotifier.send("Hello, this is a test message!");
    }
}

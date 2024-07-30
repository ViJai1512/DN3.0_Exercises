public class TestProxyPattern {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("http://example.com/image1.jpg");
        Image image2 = new ProxyImage("http://example.com/image2.jpg");

        // Image will be loaded from server
        System.out.println("First call to display image1:");
        image1.display();

        // Image will not be loaded from server, cached image will be displayed
        System.out.println("\nSecond call to display image1:");
        image1.display();

        // Image will be loaded from server
        System.out.println("\nFirst call to display image2:");
        image2.display();

        // Image will not be loaded from server, cached image will be displayed
        System.out.println("\nSecond call to display image2:");
        image2.display();
    }
}

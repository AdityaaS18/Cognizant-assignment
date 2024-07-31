package Week1DPP.ProxyPatternExample;

public class ProxyPatternExample {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("http://example.com/image1.jpg");
        Image image2 = new ProxyImage("http://example.com/image2.jpg");

        image1.display(); // loads image from server and displays
        image1.display(); // displays cached image
        image2.display(); // loads image from server and displays
        image2.display(); // displays cached image
    }
}

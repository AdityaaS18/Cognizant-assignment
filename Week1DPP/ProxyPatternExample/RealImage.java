package Week1DPP.ProxyPatternExample;

public class RealImage implements Image {
    private String url;

    public RealImage(String url) {
        this.url = url;
        loadImageFromServer();
    }

    private void loadImageFromServer() {
        System.out.println("Loading image from server...");
        // Simulate loading image from server
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Image loaded from server.");
    }

    @Override
    public void display() {
        System.out.println("Displaying image...");
    }
}

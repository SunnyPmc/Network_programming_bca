import java.io.IOException;
import java.net.*;

public class AllowUserInteractionExample {
    public static void main(String[] args) {
        try {
            // Define a URL
            URI uri = new URI("https://www.example.com");
            URL url = uri.toURL();

            // Open connection
            URLConnection connection = url.openConnection();

            // Enable user interaction
            connection.setAllowUserInteraction(true);

            // Check if user interaction is allowed
            System.out.println("Is user interaction allowed? " + connection.getAllowUserInteraction());
        } catch (URISyntaxException e) {
            System.err.println("Invalid URI: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

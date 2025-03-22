// Program to print the URL of a URLConnection to https://www.oreilly.com/

import java.io.IOException;
import java.net.*;

public class URLPrinter {
    public static void main(String[] args) {
        try {
            URI uri = new URI("https://www.oreilly.com/");
            URL url = uri.toURL();

            // Open a connection
            URLConnection uc = url.openConnection();

            // Print the URL
            System.out.println("Connected to: " + uc.getURL());
        } catch (URISyntaxException e) {
            System.err.println("Invalid URI: " + e.getMessage());
        } catch (IOException ex) {
            System.err.println("IO Error: " + ex.getMessage());
        }
    }
}

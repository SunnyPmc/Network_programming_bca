import java.net.*;
import java.util.Date;

public class RetrieveHeaderFields {
    public static void main(String[] args) {
        try {
            // Specify the URL to connect to
            URI uri = new URI("https://www.example.com");
            URL url = uri.toURL();

            // Open a connection to the URL
            URLConnection connection = url.openConnection();

            // Retrieve and print specific header fields
            System.out.println("Content Type: " + connection.getContentType());
            System.out.println("Content Length: " + connection.getContentLength());
            System.out.println("Content Encoding: " + connection.getContentEncoding());
            System.out.println("Date: " + connection.getDate());
            System.out.println("Date: " + new Date(connection.getDate()));

            System.out.println("Expiration: " + connection.getExpiration());
            System.out.println("Last Modified: " + connection.getLastModified());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

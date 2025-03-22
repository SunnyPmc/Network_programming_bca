import java.io.IOException;
import java.net.*;
import java.util.Date;

public class CheckIfModified {
    public static void main(String[] args) {
        try {
            URI uri = new URI("https://www.example.com");
            URL url = uri.toURL();

            // Open a connection
            URLConnection connection = url.openConnection();

            // Set the "ifModifiedSince" time to 24 hours ago
            long lastChecked = System.currentTimeMillis() - (24 * 60 * 60 * 1000); // 24 hours ago
            connection.setIfModifiedSince(lastChecked);

            // Get the value set
            System.out.println("If-Modified-Since: " + connection.getIfModifiedSince());
            System.out.println("If-Modified-Since: " + new Date(connection.getIfModifiedSince()));

            // Connect to the server
            connection.connect();

            // Get the last modified date of the resource
            long lastModified = connection.getLastModified();
            System.out.println("Last Modified: " + lastModified);
            System.out.println("Last Modified: " + new Date(lastModified));

            if (lastModified == 0) {
                System.out.println("The server did not provide a Last-Modified header.");
            } else if (lastModified > lastChecked) {
                System.out.println("The resource has been updated since the last check.");
            } else {
                System.out.println("The resource has not been modified since the last check.");
            }
        } catch (URISyntaxException e) {
            System.err.println("Invalid URI: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

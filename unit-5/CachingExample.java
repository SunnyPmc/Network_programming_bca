import java.net.*;
import java.util.List;
import java.util.Map;

public class CachingExample {
    public static void main(String[] args) {
        try {
            // Define the URL to connect to
            URI uri = new URI("https://www.example.com");
            URL url = uri.toURL();
            // Open a connection to the URL
            URLConnection connection = url.openConnection();

            connection.setUseCaches(true);

            // Connect to the server
            connection.connect();

            // Retrieve and print caching-related headers
            System.out.println("Caching Headers");
            printHeaderField(connection, "Cache-Control");
            printHeaderField(connection, "Expires");
            printHeaderField(connection, "ETag");
            printHeaderField(connection, "Last-Modified");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to print specific headers (if they exist)
    private static void printHeaderField(URLConnection connection, String field) {
        Map<String, List<String>> headers = connection.getHeaderFields();
        List<String> values = headers.get(field);

        if (values != null) {
            System.out.println(field + ": " + String.join(", ", values));
        } else {
            System.out.println(field + ": Not Present");
        }
    }
}

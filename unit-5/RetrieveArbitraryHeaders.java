import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class RetrieveArbitraryHeaders {
    public static void main(String[] args) {
        try {
            // Define the URL to connect to
            URI uri = new URI("https://www.example.com");
            URL url = uri.toURL();

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Connect to the server
            connection.connect();

            // Retrieve all header fields
            Map<String, List<String>> headers = connection.getHeaderFields();

            // Print all headers, including arbitrary ones
            System.out.println("=== HTTP Headers ===");
            for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
                String headerName = entry.getKey();
                List<String> headerValues = entry.getValue();

                System.out.print(headerName + ": ");
                for (String value : headerValues) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }

            // Close the connection
            connection.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

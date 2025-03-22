import java.net.*;
import java.util.*;

public class RetrieveAllHeader {
    public static void main(String[] args) {
        try {
            // Specify the URL
            URI uri = new URI("https://www.example.com");
            URL url = uri.toURL();
            URLConnection connection = url.openConnection();

            // Get all header fields as a Map
            Map<String, List<String>> headers = connection.getHeaderFields();

            // Iterate over the header map and print each field
            for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
                String headerName = entry.getKey();
                List<String> headerValues = entry.getValue();

                // Print the header name (null for status line) and values
                if (headerName != null) {
                    System.out.println(headerName + ": " + String.join(", ", headerValues));
                } else {
                    System.out.println("Status: " + String.join(", ", headerValues));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

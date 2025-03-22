import java.net.*;
import java.io.*;

public class HttpResponseExample {
    public static void main(String[] args) {
        try {

            URI uri = new URI("http://www.example.com");
            URL url = uri.toURL();

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set the request method (GET by default)
            connection.setRequestMethod("GET");

            // Get the response code
            int responseCode = connection.getResponseCode();

            // Get the response message
            String responseMessage = connection.getResponseMessage();

            // Print out the response code and message
            System.out.println("Response Code: " + responseCode);
            System.out.println("Response Message: " + responseMessage);

            // Close the connection
            connection.disconnect();
        } catch (URISyntaxException e) {
            System.err.println("Invalid URI: " + e.getMessage());
        } catch (IOException e) {
            // Handle exception if the URL connection fails
            e.printStackTrace();
        }
    }
}

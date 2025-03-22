import java.io.*;
import java.net.*;

public class DoInputExample {
    public static void main(String[] args) {
        try {
            // Create a URL object pointing to a website
            URI uri = new URI("http://www.example.com");
            URL url = uri.toURL();
            // Open a connection to the URL
            URLConnection uc = url.openConnection();

            // Check if input is allowed, if not, enable it
            if (!uc.getDoInput()) {
                uc.setDoInput(true);
            }

            // Read data from the URL
            BufferedReader reader = new BufferedReader(new InputStreamReader(uc.getInputStream()));

            // Print the first few lines of the page content
            String line;
            int count = 0;
            while ((line = reader.readLine()) != null && count < 5) { // Limiting output to 5 lines
                System.out.println(line);
                count++;
            }

            // Close the reader
            reader.close();
        } catch (URISyntaxException e) {
            System.err.println("Invalid URI: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

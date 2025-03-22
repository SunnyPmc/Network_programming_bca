import java.io.*;
import java.net.*;

public class useCachesExample {
    public static void main(String[] args) {
        try {
            // Define the URL
            URI uri = new URI("https://www.example.com");
            URL url = uri.toURL();
            // Open connection
            URLConnection uc = url.openConnection();

            // Disable caching to always fetch a fresh copy
            uc.setUseCaches(false);

            // Read and print the response
            BufferedReader reader = new BufferedReader(new InputStreamReader(uc.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Close the reader
            reader.close();
        } catch (URISyntaxException e) {
            System.err.println("Invalid URI: " + e.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

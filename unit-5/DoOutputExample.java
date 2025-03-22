import java.io.*;
import java.net.*;

public class DoOutputExample {
    public static void main(String[] args) {
        try {

            URI uri = new URI("http://www.example.com/submit");
            URL url = uri.toURL();
            // Open a connection to the URL
            URLConnection uc = url.openConnection();

            // Check if output is allowed; if not, enable it
            if (!uc.getDoOutput()) {
                uc.setDoOutput(true);
            }

            // Send data to the server using OutputStream
            OutputStream outputStream = uc.getOutputStream();
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(outputStream, "UTF-8"));

            // Writing data
            writer.println("message=HelloServer&name=User123");
            writer.flush(); // Ensure data is sent

            // Close the writer
            writer.close();

            System.out.println("Data sent successfully!");
        } catch (URISyntaxException e) {
            System.err.println("Invalid URI: " + e.getMessage());
        } catch (IOException ex) {
            System.err.println("Error: " + ex.getMessage());
        }
    }
}

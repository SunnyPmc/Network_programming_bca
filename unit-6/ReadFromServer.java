import java.io.*;
import java.net.*;

public class ReadFromServer {
    public static void main(String[] args) {
        String somehost = "example.com";
        int someport = 80;

        try {
            // Connect to the server
            Socket socket = new Socket(somehost, someport);

            // Set up input (reading) and output (writing) streams
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintStream pstream = new PrintStream(socket.getOutputStream());

            // Send an HTTP GET request
            pstream.println("GET / HTTP/1.1");
            pstream.println("Host: " + somehost);
            pstream.println("Connection: close"); // Close connection after response
            pstream.println();

            // Read and print the server response
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Close the socket
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

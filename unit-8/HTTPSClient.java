import java.io.*;
import javax.net.ssl.*;

public class HTTPSClient {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java HTTPSClient <hostname>");
            return;
        }

        String host = args[0];
        int port = 443; // HTTPS default port

        try {
            SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            SSLSocket socket = (SSLSocket) factory.createSocket(host, port);

            // Enable all supported cipher suites
            socket.setEnabledCipherSuites(socket.getSupportedCipherSuites());

            // Send HTTP GET request
            Writer out = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");
            out.write("GET / HTTP/1.1\r\n");
            out.write("Host: " + host + "\r\n");
            out.write("\r\n");
            out.flush();

            // Read response

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }

            // Close resources
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

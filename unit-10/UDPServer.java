import java.net.*;
import java.util.Date;
import java.io.IOException;

public class UDPServer {

    private final static int PORT = 12345;

    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket(PORT)) {
            System.out.println("UDP Daytime Server is running on port " + PORT);

            while (true) {
                try {
                    DatagramPacket request = new DatagramPacket(new byte[1024], 1024);
                    socket.receive(request); // Waits for client request

                    // Prepare the current date and time as a response
                    String daytime = new Date().toString();
                    byte[] data = daytime.getBytes("US-ASCII");

                    // Send the response back to the client
                    InetAddress clientAddress = request.getAddress();
                    int clientPort = request.getPort();
                    DatagramPacket response = new DatagramPacket(data, data.length, clientAddress, clientPort);
                    socket.send(response);

                    System.out.println("Responded to " + clientAddress + " at port " + clientPort);
                } catch (IOException e) {
                    System.err.println("Error handling request: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Could not start server: " + e.getMessage());
        }
    }
}

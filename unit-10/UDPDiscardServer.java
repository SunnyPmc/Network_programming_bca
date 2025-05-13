import java.net.*;
import java.io.*;

public class UDPDiscardServer {
    public static final int PORT = 9;
    public static final int MAX_PACKET_SIZE = 65507;

    public static void main(String[] args) {
        byte[] buffer = new byte[MAX_PACKET_SIZE];

        try (DatagramSocket server = new DatagramSocket(PORT)) {
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            System.out.println("Discard server is running on port " + PORT);

            while (true) {
                try {
                    server.receive(packet);

                    // Convert received bytes into a readable string
                    String receivedData = new String(packet.getData(), 0, packet.getLength(), "8859_1");

                    // Print client information and the received message
                    System.out.println("Received from " + packet.getAddress().getHostAddress() +
                            " at port " + packet.getPort() + ": " + receivedData);

                    packet.setLength(buffer.length);
                } catch (IOException ex) {
                    System.err.println("Server receive error: " + ex.getMessage());
                    ex.printStackTrace();
                }
            }
        } catch (SocketException ex) {
            System.err.println("Could not start server: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}

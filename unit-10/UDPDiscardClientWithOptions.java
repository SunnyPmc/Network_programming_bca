import java.net.*;
import java.io.*;

public class UDPDiscardClientWithOptions {
    public static final int SERVER_PORT = 9999;
    public static final String SERVER_ADDRESS = "localhost";

    public static void main(String[] args) {
        try (DatagramSocket clientSocket = new DatagramSocket()) {

            // Set socket options
            clientSocket.setSoTimeout(5000); // Timeout after 5 seconds
            clientSocket.setSendBufferSize(4096); // 4 KB send buffer
            clientSocket.setBroadcast(true); // Allow broadcasts
            clientSocket.setTrafficClass(0xB8); // Expedited forwarding service

            InetAddress serverAddress = InetAddress.getByName(SERVER_ADDRESS);

            // Connect to server (optional for UDP)
            clientSocket.connect(serverAddress, SERVER_PORT);

            String message = "Hello, UDP Server!";
            byte[] buffer = message.getBytes();
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            clientSocket.send(packet);
            System.out.println("Message sent to " + serverAddress + ":" + SERVER_PORT);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

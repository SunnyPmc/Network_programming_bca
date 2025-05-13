import java.net.*;
import java.io.*;

public class UDPDiscardServerWithOptions {
    public static final int PORT = 9999;

    public static void main(String[] args) {
        try (DatagramSocket serverSocket = new DatagramSocket(PORT)) {

            // Set some socket options
            serverSocket.setSoTimeout(10000); // Timeout after 10 seconds
            serverSocket.setReceiveBufferSize(4096); // 4 KB receive buffer
            serverSocket.setReuseAddress(true); // Allow reuse of address
            serverSocket.setBroadcast(true); // Allow broadcasts
            serverSocket.setTrafficClass(0x10); // Low delay service

            System.out.println("Server listening on port " + PORT);

            byte[] buffer = new byte[4096];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            while (true) {
                try {
                    serverSocket.receive(packet); // Wait for packet
                    String received = new String(packet.getData(), 0, packet.getLength());
                    System.out
                            .println("Received: " + received + " from " + packet.getAddress() + ":" + packet.getPort());
                    // Discard packet (no reply)
                } catch (SocketTimeoutException e) {
                    System.out.println("No packet received within timeout. Server continues listening...");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

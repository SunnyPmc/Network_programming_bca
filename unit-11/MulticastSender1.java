import java.io.IOException;
import java.net.*;

public class MulticastSender1 {
    public static void main(String[] args) {
        String multicastAddress = "230.0.0.1";
        int port = 4000;

        try (MulticastSocket socket = new MulticastSocket()) {
            InetAddress group = InetAddress.getByName(multicastAddress);

            System.out.println("Sending multicast packets...");

            for (int i = 1; i <= 5; i++) {
                String message = "Multicast Message " + i;
                byte[] buffer = message.getBytes();

                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, group, port);
                socket.send(packet);

                System.out.println("Sent packet " + i);
                Thread.sleep(1000); // Delay between packets
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

import java.io.IOException;
import java.net.*;

public class MulticastSniffer {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java MulticastSniffer <multicast-address> <port>");
            return;
        }

        String multicastAddress = args[0];
        int port = Integer.parseInt(args[1]);

        try (MulticastSocket socket = new MulticastSocket(port)) {
            InetAddress group = InetAddress.getByName(multicastAddress);

            // Choose network interface (use loopback for localhost)
            NetworkInterface netIf = NetworkInterface.getByInetAddress(InetAddress.getLocalHost());

            socket.joinGroup(new InetSocketAddress(group, port), netIf);

            System.out.println("Listening on multicast group " + multicastAddress + ":" + port);

            byte[] buffer = new byte[1024];

            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);

                String received = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Received: " + received);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

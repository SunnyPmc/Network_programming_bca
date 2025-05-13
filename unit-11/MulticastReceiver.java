import java.io.IOException;
import java.net.*;
import java.util.Enumeration;

public class MulticastReceiver {
    public static void main(String[] args) throws IOException {
        String groupAddress = "224.0.0.1";
        int port = 8888;

        InetAddress group = InetAddress.getByName(groupAddress);

        MulticastSocket socket = new MulticastSocket(port);

        // List all interfaces
        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
        while (interfaces.hasMoreElements()) {
            NetworkInterface ni = interfaces.nextElement();
            System.out.println("Found interface: " + ni.getName());
        }

        // Pick a specific interface (change as needed)
        NetworkInterface ni = NetworkInterface.getByName("wlan0");
        socket.joinGroup(new InetSocketAddress(group, port), ni);

        System.out.println("Joined group. Waiting for multicast message...");

        byte[] buffer = new byte[256];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        socket.receive(packet);
        String message = new String(packet.getData(), 0, packet.getLength());
        System.out.println("Received: " + message);

        socket.leaveGroup(new InetSocketAddress(group, port), ni);
        socket.close();
    }
}

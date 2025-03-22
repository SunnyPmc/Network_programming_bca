import java.net.*;

public class ClientExample {
    public static void main(String[] args) {
        // Creating an InetSocketAddress using a hostname
        InetSocketAddress address1 = new InetSocketAddress("www.google.com", 80);
        System.out.println("Google IP: " + address1.getAddress());
        System.out.println("Google Port: " + address1.getPort());

        // Creating an InetSocketAddress using an IP address
        InetAddress ip;
        try {
            ip = InetAddress.getByName("8.8.8.8");
            InetSocketAddress address2 = new InetSocketAddress(ip, 53);
            System.out.println("DNS Server IP: " + address2.getAddress());
            System.out.println("DNS Server Port: " + address2.getPort());
        } catch (UnknownHostException e) {
            System.err.println("Host not found: " + e.getMessage());
        }
    }
}

import java.net.*;

public class Inet4and6Address {
    public static void main(String[] args) throws Exception {
        // Inet4Address
        InetAddress address1 = Inet4Address.getByName("www.google.com");
        System.out.println("IPv4 address: " + address1.getHostAddress());
        System.out.println("Is IPv4: " + (address1 instanceof Inet4Address));

        // Inet6Address
        InetAddress address2 = Inet6Address.getByName("ipv6.google.com");
        System.out.println("IPv6 address: " + address2.getHostAddress());
        System.out.println("Is IPv6: " + (address2 instanceof Inet6Address));
    }
}

import java.net.*;
import java.util.*;

public class NetworkInterfaceExample {
    public static void main(String[] args) throws Exception {
        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();

        while (interfaces.hasMoreElements()) {
            NetworkInterface ni = interfaces.nextElement();
            System.out.println(ni);
            System.out.println("Interface name: " + ni.getName());
            System.out.println("Display name: " + ni.getDisplayName());

            Enumeration<InetAddress> addresses = ni.getInetAddresses();
            while (addresses.hasMoreElements()) {
                InetAddress address = addresses.nextElement();
                System.out.println("IP address: " + address.getHostAddress());
            }
        }
    }
}

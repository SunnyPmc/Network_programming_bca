import java.net.*;

public class GetterMethods {
    public static void main(String[] args) {
        try {
            // Create a socket and connect to a server
            Socket socket = new Socket("www.google.com", 80);

            // Get the remote socket address
            InetSocketAddress remoteAddress = (InetSocketAddress) socket.getRemoteSocketAddress();

            // Display information using getter methods
            System.out.println("Remote Hostname: " + remoteAddress.getHostName());
            System.out.println("Remote IP Address: " + remoteAddress.getAddress());
            System.out.println("Remote Port: " + remoteAddress.getPort());

            // Get the local socket address
            InetSocketAddress localAddress = (InetSocketAddress) socket.getLocalSocketAddress();

            // Display local connection details
            System.out.println("Local IP Address: " + localAddress.getAddress());
            System.out.println("Local Port: " + localAddress.getPort());

            // Close the socket
            socket.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

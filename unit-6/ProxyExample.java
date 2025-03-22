import java.net.*;

public class ProxyExample {
    public static void main(String[] args) {
        try {
            // Define a SOCKS proxy server (IP or hostname and port)
            SocketAddress proxyAddress = new InetSocketAddress("myproxy.example.com", 1080);
            Proxy proxy = new Proxy(Proxy.Type.SOCKS, proxyAddress);

            // Create a socket that connects via this proxy
            Socket socket = new Socket(proxy);

            // Connect to the destination server (e.g., SMTP email server on port 25)
            SocketAddress remoteAddress = new InetSocketAddress("login.ibiblio.org", 25);
            socket.connect(remoteAddress);

            System.out.println("Connected via Proxy!");
            socket.close();
        } catch (Exception e) {
            System.err.println("Connection Failed: " + e.getMessage());
        }
    }
}

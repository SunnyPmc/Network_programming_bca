import java.net.*;
import java.nio.*;
import java.nio.channels.*;

public class UDPDiscardClientWithChannels {
    public static final int PORT = 9999;

    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            System.out.println("Usage: java UDPDiscardClientWithChannels <hostname/IP>");
            return;
        }
        String hostname = args[0];
        InetSocketAddress serverAddress = new InetSocketAddress(hostname, PORT);

        try (DatagramChannel channel = DatagramChannel.open()) {
            channel.connect(serverAddress);

            ByteBuffer buffer = ByteBuffer.allocate(4);
            buffer.putInt(42);
            buffer.flip();

            channel.write(buffer);
            System.out.println("Sent: 42 to " + serverAddress);
        }
    }
}

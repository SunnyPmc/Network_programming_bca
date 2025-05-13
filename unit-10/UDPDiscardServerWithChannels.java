import java.net.*;
import java.nio.*;
import java.nio.channels.*;

public class UDPDiscardServerWithChannels {
    public static final int PORT = 9999;

    public static void main(String[] args) throws Exception {
        DatagramChannel channel = DatagramChannel.open();
        channel.bind(new InetSocketAddress(PORT));

        System.out.println("UDP Discard Server is running on port " + PORT);

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        while (true) {
            buffer.clear();
            SocketAddress clientAddress = channel.receive(buffer);

            if (clientAddress != null) {
                buffer.flip();
                System.out.println("Received " + buffer.limit() + " bytes from " + clientAddress);

            }
        }
    }
}

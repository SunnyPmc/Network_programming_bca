import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketOption;
import java.net.StandardSocketOptions;
import java.nio.channels.SocketChannel;
import java.util.Set;

public class SocketOptionsDemo {
    public static void main(String[] args) throws IOException {
        // Create and connect the SocketChannel
        SocketChannel channel = SocketChannel.open();
        channel.connect(new InetSocketAddress("example.com", 80));

        // Set some options
        channel.setOption(StandardSocketOptions.SO_KEEPALIVE, true);
        channel.setOption(StandardSocketOptions.TCP_NODELAY, true);
        channel.setOption(StandardSocketOptions.SO_RCVBUF, 16 * 1024); // 16KB

        // Get current option values
        boolean keepAlive = channel.getOption(StandardSocketOptions.SO_KEEPALIVE);
        int receiveBuffer = channel.getOption(StandardSocketOptions.SO_RCVBUF);

        System.out.println("SO_KEEPALIVE: " + keepAlive);
        System.out.println("SO_RCVBUF: " + receiveBuffer);

        // Show all supported options
        Set<SocketOption<?>> options = channel.supportedOptions();
        System.out.println("\nSupported options:");
        for (SocketOption<?> option : options) {
            System.out.println("- " + option.name());
        }

        channel.close();
    }
}

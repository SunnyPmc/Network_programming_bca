import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class SelectorServer {
    public static void main(String[] args) {
        try {
            // 1. Open selector and server channel
            Selector selector = Selector.open();
            ServerSocketChannel serverChannel = ServerSocketChannel.open();

            // 2. Configure server to be non-blocking
            serverChannel.configureBlocking(false);
            serverChannel.bind(new InetSocketAddress(5000));

            // 3. Register server with selector for OP_ACCEPT
            serverChannel.register(selector, SelectionKey.OP_ACCEPT);

            System.out.println("Server started on port 5000...");

            while (true) {
                // 4. Wait for events
                selector.select(); // blocks

                Set<SelectionKey> keys = selector.selectedKeys();
                Iterator<SelectionKey> it = keys.iterator();

                while (it.hasNext()) {
                    SelectionKey key = it.next();
                    it.remove(); // Always remove handled key

                    if (key.isAcceptable()) {
                        // 5. Accept new client
                        ServerSocketChannel server = (ServerSocketChannel) key.channel();
                        SocketChannel clientChannel = server.accept();
                        clientChannel.configureBlocking(false);

                        // Register client for reading
                        clientChannel.register(selector, SelectionKey.OP_READ);
                        System.out.println("Accepted connection from: " + clientChannel.getRemoteAddress());

                    } else if (key.isReadable()) {
                        // 6. Read data from client
                        SocketChannel clientChannel = (SocketChannel) key.channel();
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        int bytesRead = clientChannel.read(buffer);

                        if (bytesRead == -1) {
                            // Client closed connection
                            System.out.println("Client disconnected: " + clientChannel.getRemoteAddress());
                            clientChannel.close();
                        } else {
                            buffer.flip();
                            String msg = new String(buffer.array(), 0, buffer.limit());
                            System.out.println("Received: " + msg.trim());

                            // Respond back
                            buffer.clear();
                            buffer.put("Hello from server!\n".getBytes());
                            buffer.flip();
                            clientChannel.write(buffer);
                        }
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

import java.io.*;
import java.net.*;
import java.util.Date;

public class MultiThreadedDaytimeServer {
    private static final int PORT = 43;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Daytime Server running on port " + PORT);

            while (true) {
                Socket client = server.accept();
                new ClientHandler(client).start(); // Start a new thread for each client
            }
        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }
}

// Handles client requests in a separate thread
class ClientHandler extends Thread {
    private final Socket client;

    public ClientHandler(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try (Writer out = new OutputStreamWriter(client.getOutputStream())) {
            out.write(new Date().toString() + "\r\n");
            out.flush();
        } catch (IOException e) {
            System.err.println("Client error: " + e.getMessage());
        } finally {
            try {
                client.close();
            } catch (IOException ignored) {
            }
        }
    }
}

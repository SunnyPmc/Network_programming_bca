import java.net.*;
import java.io.*;

public class UDPDiscardClient {
    public static final int PORT = 9;

    public static void main(String[] args) {
        String hostname = args.length > 0 ? args[0] : "localhost";

        try (DatagramSocket theSocket = new DatagramSocket()) {
            InetAddress server = InetAddress.getByName(hostname);
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Enter text to send to the discard server (type '.' alone to quit):");

            while (true) {
                String theLine = userInput.readLine();
                if (theLine == null || theLine.equals(".")) {
                    break;
                }

                byte[] data = theLine.getBytes();
                DatagramPacket theOutput = new DatagramPacket(data, data.length, server, PORT);

                theSocket.send(theOutput);
            }
        } catch (IOException ex) {
            System.err.println("Client error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}

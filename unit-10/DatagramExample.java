import java.io.*;
import java.net.*;

public class DatagramExample {
    public static void main(String[] args) {
        String s = "This is a test.";
        try {
            byte[] data = s.getBytes("UTF-8");
            InetAddress ia = InetAddress.getByName("www.ibiblio.org");
            int port = 7;

            DatagramPacket dp = new DatagramPacket(data, data.length, ia, port);

            System.out.println("This packet is addressed to " + dp.getAddress() + " on port " + dp.getPort());
            System.out.println("There are " + dp.getLength() + " bytes of data in the packet");

            // Correctly converts only the actual data from the packet
            System.out.println(new String(dp.getData(), dp.getOffset(), dp.getLength(), "UTF-8"));
        } catch (UnknownHostException | UnsupportedEncodingException ex) {
            System.err.println(ex);
        }
    }
}

import java.net.*;

public class SpamCheck {
    public static void main(String[] args) {
        String spamServer = "spam.example.com";

        try {
            InetAddress address = InetAddress.getByName(spamServer);
            System.out.println("This might me a spam address: " + address.getHostAddress());
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("This is not a spam address");
        }
    }
}

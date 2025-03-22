import java.net.*;

public class RetrievingUrl {
    public static void main(String[] args) {
        try {
            URI uri = new URI("https://example.com:8080/report#1.pdf");
            URL url = uri.toURL();
            System.out.println("URL: " + url);
            System.out.println("Protocol: " + url.getProtocol());
            System.out.println("Host: " + url.getHost());
            System.out.println("Path: " + url.getPath());
            System.out.println("query: " + url.getQuery());
            System.out.println("PORT: " + url.getPort());
            System.out.println("Fragment: " + url.getRef());
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("An error occured: " + e.getMessage());
        }
    }
}
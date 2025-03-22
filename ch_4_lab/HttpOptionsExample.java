import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class HttpOptionsExample {
    public static void main(String[] args) throws Exception {
        URI uri = new URI("https://httpbin.org/");
        URL url = uri.toURL();
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("OPTIONS");

        // Get response code
        int responseCode = conn.getResponseCode();
        System.out.println("Response Code: " + responseCode);

        // Get allowed methods
        String allowedMethods = conn.getHeaderField("Allow");
        System.out.println("Allowed Methods: " + allowedMethods);

    }
}

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.Map;

public class HttpHeadExample {
    public static void main(String[] args) throws Exception {
        URI uri = new URI("https://www.google.com");
        URL url = uri.toURL();
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("HEAD");

        int responseCode = conn.getResponseCode();
        System.out.println("Response Code: " + responseCode);

        // Print response headers
        for (Map.Entry<String, java.util.List<String>> entry : conn.getHeaderFields().entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

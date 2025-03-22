import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class HttpDeleteExample {
    public static void main(String[] args) throws Exception {
        URI uri = new URI("https://jsonplaceholder.typicode.com/posts/1");
        URL url = uri.toURL();
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("DELETE");

        int responseCode = conn.getResponseCode();
        System.out.println("Response Code: " + responseCode);
    }
}

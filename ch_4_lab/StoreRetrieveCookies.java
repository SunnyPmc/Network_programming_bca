import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;
import java.util.List;

public class StoreRetrieveCookies {
    public static void main(String[] args) throws Exception {
        // Custom CookieManager that accepts all cookies
        CookieManager customCookieManager = new CookieManager(null, CookiePolicy.ACCEPT_ALL);
        CookieHandler.setDefault(customCookieManager);

        // Request to set cookies
        URI uri = new URI("https://httpbin.org/cookies/set?username=JohnDoe");
        URL url = uri.toURL();
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        // Read response
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        while (in.readLine() != null) {
        } // Ignore content
        in.close();

        // Retrieve stored cookies
        CookieStore cookieStore = customCookieManager.getCookieStore();
        List<HttpCookie> cookies = cookieStore.getCookies();
        System.out.println("Stored Cookies:");
        for (HttpCookie cookie : cookies) {
            System.out.println(cookie);
        }
    }
}

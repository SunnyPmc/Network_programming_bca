import java.net.URI;

public class URItoString {
    public static void main(String[] args) throws Exception {
        URI uri = new URI("https://example.com/path/to/page?query=value#section");

        System.out.println("URI as String: " + uri.toString());
        System.out.println("Raw Path: " + uri.getRawPath());
        System.out.println("Raw Query: " + uri.getRawQuery());
        // System.out.println("Raw Fragment: " + uri.getRawFragment());
    }
}

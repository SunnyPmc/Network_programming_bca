import java.net.*;

public class ComparingUrl {
    public static void main(String[] args) throws Exception {
        URI uri1 = new URI("https://example.com");
        URI uri2 = new URI("https://example.com");
        URI uri3 = new URI("https://example.com/page.html");

        URL url1 = uri1.toURL();
        URL url2 = uri2.toURL();
        URL url3 = uri3.toURL();

        System.out.println("URL1 and URL2 are same: " + url1.equals(url2));
        System.out.println("URL1 and URL3 are same: " + url1.equals(url3));
        System.out.println("URL1 and URL3 are same: " + url1.sameFile(url3));
    }
}

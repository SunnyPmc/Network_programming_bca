import java.net.URLConnection;

public class MimeTypeGuesser {
    public static void main(String[] args) {

        String filePath = "Numerical.pdf";
        // Guess MIME type from file name
        String mimeTypeByName = URLConnection.guessContentTypeFromName(filePath);
        System.out.println("MIME Type (by file name): " + mimeTypeByName);
    }
}

import java.net.*;
import java.nio.charset.StandardCharsets;

public class URLDecoding {
    public static void main(String[] args) {
        try {
            String encodedFilename = "report+%231.pdf";
            String decodedFilename = URLDecoder.decode(encodedFilename, StandardCharsets.UTF_8);

            System.out.println("Encode filename: " + encodedFilename);
            System.out.println("Decoded filename: " + decodedFilename);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("An error occured: " + e.getMessage());
        }
    }
}

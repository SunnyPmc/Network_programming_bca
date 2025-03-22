import java.io.*;
import java.nio.file.*;

public class MimeTypeGuesser1 {
    public static void main(String[] args) {
        String filePath = "Numerical.pdf";

        // Guess MIME type using Files.probeContentType()
        try {
            Path path = Paths.get(filePath);
            String mimeType = Files.probeContentType(path);
            System.out.println("MIME Type (by file content): " + mimeType);
        } catch (IOException e) {
            System.out.println("Error determining MIME type: " + e.getMessage());
        }
    }
}

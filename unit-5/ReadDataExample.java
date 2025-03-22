import java.net.*;
import java.io.*;

public class ReadDataExample {
    public static void main(String[] args) throws Exception {
        URI uri = new URI("https://www.example.com");
        URL url = uri.toURL();
        URLConnection connection = url.openConnection();
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }
}

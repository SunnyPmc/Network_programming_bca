import java.io.*;
import java.net.*;
import java.util.Date;

public class DayTimeServer {
    public static final int PORT = 13;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            while (true) {
                try (Socket connection = server.accept();
                     Writer out = new OutputStreamWriter(connection.getOutputStream())) {
                    
                    out.write(new Date().toString() + "\r\n");
                    out.flush();
                } catch (IOException ignored) {}
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}

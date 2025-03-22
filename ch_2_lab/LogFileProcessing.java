import java.io.*;

public class LogFileProcessing {
    public static void main(String[] args) {
        String logFile = "server.log";

        try (BufferedReader br = new BufferedReader(new FileReader(logFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains("200")) {
                    System.out.println(line);
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error processing logfile " + e.getMessage());
        }
    }
}

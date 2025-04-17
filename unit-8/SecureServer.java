//1.Generate a key pair using the command: keytool -genkeypair -alias myserver -keyalg RSA -keystore mykeystore.jks -storepass changeit

//2.Get certificate signed by a trusted Certificate authority

import java.io.*;
import java.net.*;
import java.security.*;
import javax.net.ssl.*;

public class SecureServer {
    public static final int PORT = 7000;
    public static final String ALGORITHM = "TLS";
    public static final String password = "SUNNY@123";

    public static void main(String[] args) {
        try {
            // 3.Load the SSL Context
            SSLContext context = SSLContext.getInstance(ALGORITHM);
            KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
            KeyStore ks = KeyStore.getInstance("JKS");

            // 4.Load keystore (must contain server's private key)
            char[] pass = password.toCharArray();
            ks.load(new FileInputStream("server.keystore"), pass);
            kmf.init(ks, pass);
            context.init(kmf.getKeyManagers(), null, new SecureRandom());

            // 5.Create SSL Server Socket
            SSLServerSocketFactory factory = context.getServerSocketFactory();
            SSLServerSocket serverSocket = (SSLServerSocket) factory.createServerSocket(PORT);

            // 6.Enable cipher suites
            serverSocket.setEnabledCipherSuites(serverSocket.getSupportedCipherSuites());

            System.out.println("Secure server started on port " + PORT);

            while (true) {
                // 7.Accept secure client connection
                try (Socket clientSocket = serverSocket.accept()) {
                    System.out.println("Client connected: " + clientSocket.getInetAddress());
                    BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    String message;
                    while ((message = reader.readLine()) != null) {
                        System.out.println("Received: " + message);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

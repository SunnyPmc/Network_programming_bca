import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) {
        try {
            HelloService service = new HelloServiceImpl();

            // Start the RMI registry programmatically on port 2000
            Registry registry = LocateRegistry.createRegistry(2000);

            // Bind the service
            registry.rebind("HelloService", service);

            System.out.println("Server is ready.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

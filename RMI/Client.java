import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) {
        try {
            // Get the RMI registry on localhost at port 1099
            Registry registry = LocateRegistry.getRegistry("localhost", 2000);

            // Lookup the HelloService
            HelloService service = (HelloService) registry.lookup("HelloService");

            // Invoke the remote method
            String response = service.sayHello("Alice");
            System.out.println("Response from server: " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

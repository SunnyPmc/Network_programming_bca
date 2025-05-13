import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class HelloServiceImpl extends UnicastRemoteObject implements HelloService {
    protected HelloServiceImpl() throws RemoteException {
        super();
    }

    public String sayHello(String name) throws RemoteException {
        return "Hello, " + name + "!";
    }
}

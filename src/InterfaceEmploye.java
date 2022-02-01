import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceEmploye extends Remote {

    Cannette retirer() throws RemoteException;
}

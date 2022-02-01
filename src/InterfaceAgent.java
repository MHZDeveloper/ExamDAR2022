import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface InterfaceAgent extends Remote {
    void recharger(ArrayList<Cannette> cannettes) throws RemoteException;
}

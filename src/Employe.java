import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Employe {

    public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
        InterfaceEmploye service = (InterfaceEmploye) Naming.lookup("rmi://127.0.0.1:1250/dist");
        Cannette cannette = service.retirer();
        if (cannette == null) System.out.println("Oh ! distributeur vide :/ ");
        else System.out.println("j'ai une cannette ayant l'id : " + cannette.getId());
    }
}

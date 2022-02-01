import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class Distributeur extends UnicastRemoteObject implements InterfaceEmploye, InterfaceAgent {

    private List<Cannette> cannettes = new ArrayList<>();
    private int capacite =50;

    public Distributeur() throws RemoteException {
    }

    @Override
    public void recharger(ArrayList<Cannette> cannettes) throws RemoteException {
        while (this.cannettes.size()<capacite && !cannettes.isEmpty())
            this.cannettes.add(cannettes.remove(0));
        System.out.println("Distributeur Rechargé");
    }

    @Override
    public Cannette retirer() throws RemoteException {
        if (!cannettes.isEmpty()) {
            System.out.println("Cannette Retirée");
            return cannettes.remove(0);
        }
        System.out.println("Distributeur Vide !!");
        return null;
    }

    public static void main(String[] args) throws RemoteException, MalformedURLException {
        Distributeur distributeur = new Distributeur();
        System.out.println("Distributeur en Marche");
        java.rmi.registry.LocateRegistry.createRegistry(1250);

        Naming.rebind("rmi://127.0.0.1:1250/dist", distributeur);
    }
}

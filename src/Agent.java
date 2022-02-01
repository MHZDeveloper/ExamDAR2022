import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class Agent {

    public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
        InterfaceAgent service = (InterfaceAgent) Naming.lookup("rmi://127.0.0.1:1250/dist");

        ArrayList<Cannette> cannettes = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            cannettes.add(new Cannette(generateID()));

        service.recharger(cannettes);
        System.out.println("J'ai rechargé le distributeur :)");
    }

    private static int generateID() {
        return (int) (Math.random() * 50) + 1;
    }
}

package Class;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashMap;

import Interfaces.InterfaceEPS1;
import Interfaces.InterfaceIPS;

public class EPS1 implements InterfaceEPS1 {

	String name;
    HashMap<Integer, Patient> usuarios = new HashMap<Integer, Patient>();

	
	public EPS1(String[] args) throws RemoteException, NotBoundException {
        this.name = args[0];
        //listaEPS();
        Registry registry = LocateRegistry.getRegistry(args[1], 5555);
        InterfaceIPS newEps = (InterfaceIPS) registry.lookup("ips");
        newEps.createEPS(this.name, args[2]);
    }
}

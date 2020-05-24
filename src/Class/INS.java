package Class;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import Interfaces.InterfaceINS;
import Interfaces.InterfaceIPS;

public class INS implements InterfaceINS {


	 public INS(String[] args) throws RemoteException, NotBoundException {
	        Registry registry = LocateRegistry.getRegistry(args[0], 5555);
	        InterfaceIPS ipsNueva = (InterfaceIPS) registry.lookup("ips");
	        ipsNueva.createINS(args[1]);
	    }

	public INS() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int evPatient(Patient p) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}
}

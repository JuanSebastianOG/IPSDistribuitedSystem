package Class;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import Interfaces.InterfaceINS;
import Interfaces.InterfaceIPS;

public class INS implements InterfaceINS {


	 public INS(String[] args) throws RemoteException, NotBoundException {
	        Registry registry = LocateRegistry.getRegistry(args[1], 5555);
	        InterfaceIPS ipsNueva = (InterfaceIPS) registry.lookup("ips");
	        ipsNueva.createINS(args[1]);
	    }

	public INS() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int evPatient(Patient p) throws RemoteException {
		// TODO Auto-generated method stub

		int peso = 0;
		
		if((p.isFiebre() && p.isTos() && p.isCansancio() && p.isDolor()) && (p.isFaltaAire() || p.isInsuficienciaPulmonar()
				|| p.isShockSeptico() || p.isFallaOrganica())) {
			peso += 60;
		}
		if(p.isOtrasTatologias()) {
			peso += 10;
		}
		if(p.isCirugias()) {
			peso += 10;
		}
		if(p.getAge() > 70) {
			peso += 20;
		} else {
			peso += 10;
		}
		
		return peso;
	}
	
	
}

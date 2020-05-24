package Class;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import Interfaces.InterfaceIPS;

public class IPS implements InterfaceIPS{

	String myINSIP;
	@Override
	public String assignAppointment(String name, String document, String age, String eps, String ip, String fiebre,
			String tos, String cansancio, String dolor, String faltaAire, String insuficienciaPulmonar,
			String shockSeptico, String fallaOrganica, String otrasTatologias, String cirugias)
			throws RemoteException, NotBoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean createINS(String ip) throws RemoteException {	
		// TODO Auto-generated method stub
		myINSIP = ip;
        return true;
	}

	@Override
	public boolean createEPS(String nombre, String ip) throws RemoteException {
		// TODO Auto-generated method stub
		
		 //falta añadir a lista de eps
	     System.out.println("->" + nombre + "->" + ip);
	     return true;
	}

}

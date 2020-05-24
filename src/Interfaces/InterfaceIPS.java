package Interfaces;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceIPS extends Remote{
	 
	//Main function, this assign an medical appointment if all terms are ok
	public String assignAppointment(String name, String document,String age, String eps, String ip, String fiebre, 
			String tos, String cansancio, String dolor, String faltaAire, String insuficienciaPulmonar, String shockSeptico,
			String fallaOrganica, String otrasTatologias, String cirugias) throws RemoteException, NotBoundException;

	//Instance the unique INS
	  public boolean createINS(String ip) throws RemoteException;

	  //Instance in a list of EPS
	  public boolean createEPS(String nombre, String ip) throws RemoteException;
	  	
}

package Interfaces;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import Class.EPS1;
import Class.Patient;

public interface InterfaceIPS extends Remote{
	 
	//Instance the unique INS
	 public boolean createINS(String ip) throws RemoteException;

	 //Instance in a list of EPS
	public boolean createEPS(EPS1 eps) throws RemoteException;

	//Main function, this assign an medical appointment if all terms are ok
	public void assignAppointment(Patient p) throws RemoteException, NotBoundException;
	
	public int getCount() throws RemoteException, NotBoundException;
	
}

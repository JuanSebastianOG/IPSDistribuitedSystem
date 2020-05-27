package Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import Class.Patient;

public interface InterfaceClient1 extends Remote {

	public void setPeso(int evPatient) throws RemoteException;
	
	public void reciveNot(Patient p,int val) throws RemoteException;


}

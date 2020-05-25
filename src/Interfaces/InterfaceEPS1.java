package Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import Class.Patient;

public interface InterfaceEPS1 extends Remote{

	public void addPatient(Patient p) throws RemoteException ;

}

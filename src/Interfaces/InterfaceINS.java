package Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import Class.Patient;

public interface InterfaceINS extends Remote {

	public int evPatient(Patient p) throws RemoteException;

}

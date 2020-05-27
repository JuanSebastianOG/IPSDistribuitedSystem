package Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import Class.Patient;

public interface InterfaceEPS1 extends Remote{

	public void addPatient(Patient p) throws RemoteException ;
	
	public boolean haveCovert(Patient p) throws RemoteException;
	
	public boolean setAppointment(Patient p) throws RemoteException;
	
	public Patient setUrgAppointment(Patient p) throws RemoteException;

}

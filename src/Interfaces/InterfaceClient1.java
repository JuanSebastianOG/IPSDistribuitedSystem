package Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceClient1 extends Remote {

	public void setPeso(int evPatient) throws RemoteException;

}

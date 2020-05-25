package Class;

import java.rmi.RemoteException;
import java.util.HashMap;

import Interfaces.InterfaceClient1;

public class Client1 implements InterfaceClient1 {

    HashMap<String, Patient> patients = new HashMap<String, Patient>();

	@Override
	public void setPeso(int evPatient) throws RemoteException{
		// TODO Auto-generated method stub
		
	}

}

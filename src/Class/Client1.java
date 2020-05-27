package Class;

import java.rmi.RemoteException;
import java.util.HashMap;

import Interfaces.InterfaceClient1;

public class Client1 implements InterfaceClient1 {

    HashMap<String, Patient> patients = new HashMap<String, Patient>();
    int clientPort;
    String clientIP;

	@Override
	public void setPeso(int evPatient) throws RemoteException{
		// TODO Auto-generated method stub
		
	}

	public Client1(int clientPort, String clientIP) {
		super();
		this.clientPort = clientPort;
		this.clientIP = clientIP;
	}

	@Override
	public void reciveNot(Patient p,int val) throws RemoteException {
		// TODO Auto-generated method stub
		
		switch(val) {
		  case 1:
		    // code block
			  if(p!=null) {
				System.out.println("A el paciente: "+p.getName()+" se le modificó la fecha de la cita ");
			  }
		    break;
		  case 2:
		    // code block
				System.out.println("A el paciente  "+p.getName()+" se le asigno una cita ");
		    break;
		  case 3:
			    // code block
					System.out.println("A el paciente  "+p.getName()+" no se le asigno ya que no cumple criterios ");
			    break;
		  default:
		    // code block
		}
	}

}

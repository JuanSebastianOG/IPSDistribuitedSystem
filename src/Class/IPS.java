package Class;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashMap;

import org.omg.CORBA._PolicyStub;

import Interfaces.InterfaceClient1;
import Interfaces.InterfaceEPS1;
import Interfaces.InterfaceINS;
import Interfaces.InterfaceIPS;

public class IPS implements InterfaceIPS{

	String myINSIP;
    HashMap<String, EPS1> epss = new HashMap<String, EPS1>();
	
	@Override
	public String assignAppointment(Patient p)
			throws RemoteException, NotBoundException {
		// TODO Auto-generated method stub
		
        System.out.println("LLEGUEEEE");

		EPS1 eps1 = epss.get(p.getEps());
        
        
		Registry registry = LocateRegistry.getRegistry(myINSIP, 5554);
        InterfaceINS remINS=  (InterfaceINS) registry.lookup("ins");
        if(eps1!=null) {
        Registry registrys = LocateRegistry.getRegistry(eps1.getIpEPS(), eps1.getPort());
        
        InterfaceEPS1 remEPS=  (InterfaceEPS1) registrys.lookup("eps1");
        
		
			Registry registrysP = LocateRegistry.getRegistry(p.getIp(), 5552);
			//InterfaceClient1 remP	=  (InterfaceClient1) registrysP.lookup("client1");
			
			remEPS.addPatient(p);
			p.setPrioridad(remINS.evPatient(p));
			if(remINS.evPatient(p)<70) {
				System.out.println("El paciente "+p.getName() + " no cumple puntos necesarios");
			}else {
				if(remINS.evPatient(p)>90) {
					System.out.println("El paciente "+p.getName() + " esta grave > 90 cita al dia siguiente");
					System.out.println("Si no hay se reprograma a la del paciente con menor prioridad ");
				}else {
					System.out.println("El paciente "+p.getName() + " cita normal");

				}
			}
			
		}else {
			System.out.println("El paciente "+p.getName()+" no tiene eps asociada");
		}
		
		return null;
	}

	@Override
	public boolean createINS(String ip) throws RemoteException {	
		// TODO Auto-generated method stub
		myINSIP = ip;
        return true;
	}

	@Override
	public boolean createEPS(EPS1 eps) throws RemoteException {
		
		 //falta añadir a lista de eps
		 this.epss.put(eps.getName(), eps);
	     System.out.println("->" + eps.getIpEPS() + "->" + eps.getName());
	     return true;
	}

}

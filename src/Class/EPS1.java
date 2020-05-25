package Class;

import java.io.Serializable;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashMap;

import Interfaces.InterfaceEPS1;
import Interfaces.InterfaceIPS;

public class EPS1 implements InterfaceEPS1, Serializable {

	String name;
	int port;
	String ipEPS;
    HashMap<Integer, Patient> usuarios = new HashMap<Integer, Patient>();

	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getPort() {
		return port;
	}


	public void setPort(int port) {
		this.port = port;
	}


	public String getIpEPS() {
		return ipEPS;
	}


	public void setIpEPS(String ipEPS) {
		this.ipEPS = ipEPS;
	}


	public HashMap<Integer, Patient> getUsuarios() {
		return usuarios;
	}


	public void setUsuarios(HashMap<Integer, Patient> usuarios) {
		this.usuarios = usuarios;
	}


	public EPS1(String[] args) throws RemoteException, NotBoundException {
        this.name = args[0];
        this.port= Integer.parseInt(args[3]);
        this.ipEPS = args[1];
        //listaEPS();
        Registry registry = LocateRegistry.getRegistry(args[1], 5555);
        InterfaceIPS newEps = (InterfaceIPS) registry.lookup("ips");
        newEps.createEPS(this);
    }


	@Override
	public void addPatient(Patient p) {
		// TODO Auto-generated method stub
		usuarios.put(p.getDocument(), p);
		System.out.println("Meti al paciente: "+usuarios.get(p.getDocument()));
	}
	
}

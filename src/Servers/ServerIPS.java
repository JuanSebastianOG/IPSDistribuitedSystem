package Servers;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import Class.IPS;
import Interfaces.InterfaceIPS;

public class ServerIPS {

	public static void main(String[] args) throws RemoteException, AlreadyBoundException {
		// TODO Auto-generated method stub
		Registry registry = LocateRegistry.createRegistry(5555);
		
		IPS ips = new IPS();
		InterfaceIPS remInvoIPS = (InterfaceIPS) UnicastRemoteObject.exportObject(ips, 0);
		registry.bind("ips", remInvoIPS);
		
		System.out.println("Registry IPS comenzó...");

	}

}

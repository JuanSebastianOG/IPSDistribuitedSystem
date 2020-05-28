package Servers;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import Class.EPS1;
import Class.IPS;
import Interfaces.InterfaceEPS1;
import Interfaces.InterfaceIPS;

public class ServerEPS1 {

	public static void main(String[] args) throws RemoteException, AlreadyBoundException, UnknownHostException, NotBoundException {
		// TODO Auto-generated method stub
		Registry registry = LocateRegistry.createRegistry(5546);
		Inet4Address host = (Inet4Address) Inet4Address.getLocalHost();
		
		String[] arg= {"Colsanitas",host.getHostAddress(),host.getHostAddress(),"5546","A","B","C"};

		EPS1 eps1 = new EPS1(arg);
		InterfaceEPS1 remInvoEPS = (InterfaceEPS1) UnicastRemoteObject.exportObject(eps1, 0);
		registry.bind("eps1", (Remote) remInvoEPS);
		
		System.out.println("Registry EPS1 comenzó... EPS: "+arg[0]);
	}

}

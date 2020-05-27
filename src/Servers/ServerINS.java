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

import Class.INS;
import Class.IPS;
import Interfaces.InterfaceINS;
import Interfaces.InterfaceIPS;

public class ServerINS {

	public static void main(String[] args) throws RemoteException, AlreadyBoundException, NotBoundException, UnknownHostException {
		// TODO Auto-generated method stub

		Registry registry = LocateRegistry.createRegistry(5554);
		Inet4Address host = (Inet4Address) Inet4Address.getLocalHost();
		String[] arg= {"Colsaluds",host.getHostAddress()};
		INS ins = new INS(arg);
		InterfaceINS remInvoINS = (InterfaceINS) UnicastRemoteObject.exportObject((Remote) ins, 0);
		registry.bind("ins", (Remote) remInvoINS);
		
		System.out.println("Registry INS comenzó...");

	}

}

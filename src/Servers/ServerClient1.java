package Servers;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import Class.Client1;
import Class.EPS1;
import Class.Patient;
import Interfaces.InterfaceClient1;
import Interfaces.InterfaceEPS1;

public class ServerClient1 {

	public static void main(String[] args) throws AlreadyBoundException, IOException {
		// TODO Auto-generated method stub
		Registry registry = LocateRegistry.createRegistry(5552);
		
		//Lee los pacientes
		BufferedReader br = new BufferedReader(new FileReader(new File("./pacientes.txt")));
		String line = br.readLine();
		ArrayList<Patient> lp= new ArrayList<Patient>();
		int cont=0;
		while (line != null) {
			String[] sep = line.split(";");
			Patient nuevo = new Patient(sep[0],Integer.parseInt(sep[1]), Integer.parseInt(sep[2]),
					sep[3], Integer.parseInt(sep[4]),
					Boolean.parseBoolean(sep[5]),Boolean.parseBoolean(sep[6]),
					Boolean.parseBoolean(sep[7]),Boolean.parseBoolean(sep[8]),
					Boolean.parseBoolean(sep[9]),Boolean.parseBoolean(sep[10]),
					Boolean.parseBoolean(sep[11]),Boolean.parseBoolean(sep[12])
					,Boolean.parseBoolean(sep[13]),Boolean.parseBoolean(sep[10]));
			cont++;
			lp.add(nuevo);
			line = br.readLine();
		}
		br.close();
		
		for(Patient p:lp) {
			System.out.println(p);
		}
		
		
		Client1 client1 = new Client1();
		InterfaceClient1 remInvoClient1 = (InterfaceClient1) UnicastRemoteObject.exportObject(client1, 0);
		registry.bind("client1",  remInvoClient1);
		
		System.out.println("Registry Client1 comenzó...");

	}

}

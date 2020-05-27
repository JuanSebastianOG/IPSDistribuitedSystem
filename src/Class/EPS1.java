package Class;

import java.io.Serializable;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.HashMap;

import Interfaces.InterfaceEPS1;
import Interfaces.InterfaceIPS;

public class EPS1 implements InterfaceEPS1, Serializable {

	String name;
	int port;
	String ipEPS;
	HashMap<Integer, Patient> usuarios = new HashMap<Integer, Patient>();
	ArrayList<String> priorityD = new ArrayList<String>();
	Patient[][] matAppointments = new Patient[4][7];
	int contCol = 0;
	int contRow = 0;

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
		this.port = Integer.parseInt(args[3]);
		this.ipEPS = args[1];
		this.priorityD.add(args[4]);
		this.priorityD.add(args[5]);
		this.priorityD.add(args[6]);

		// listaEPS();
		Registry registry = LocateRegistry.getRegistry(args[1], 5555);
		InterfaceIPS newEps = (InterfaceIPS) registry.lookup("ips");
		newEps.createEPS(this);
	}

	@Override
	public void addPatient(Patient p) {
		// TODO Auto-generated method stub
		usuarios.put(p.getDocument(), p);
	}

	@Override
	public boolean haveCovert(Patient p) throws RemoteException {
		// TODO Auto-generated method stub
		for (String s : priorityD) {
			if (p.getPlan().equals(s)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean setAppointment(Patient p) throws RemoteException {
		// TODO Auto-generated method stub

		synchronized (this) {

			matAppointments[contRow][contCol] = p;
			contCol++;
			if (contCol == 7) {
				contCol = 0;
				contRow++;
			}
			for(int i=0;i<4;i++) {
				for(int j=0;j<7;j++) {
					if(matAppointments[i][j]!=null) {
						System.out.print(matAppointments[i][j].getName()+"\t");
					}else {
						System.out.print(" 0 \t ");
					}
				}
				System.out.println();
				System.out.println();
			}
			System.out.println();
            System.out.println("------------------------------------------------------------------------");
			System.out.println();
			return true;
		}
		
	}

	@Override
	public Patient setUrgAppointment(Patient p) throws RemoteException {
		// TODO Auto-generated method stub
		synchronized (this) {
			if(matAppointments[0][0] == null) {
				  matAppointments[contRow][contCol] = p;
		            contCol++;
		            if (contCol == 7) {
		                contCol = 0;
		                contRow++;
		            }
		            for(int i=0;i<4;i++) {
						for(int j=0;j<7;j++) {
							if(matAppointments[i][j]!=null) {
								System.out.print(matAppointments[i][j].getName()+"\t");
							}else {
								System.out.print(" 0 \t ");
							}
						}
						System.out.println();
						System.out.println();
					}
		            System.out.println();
		            System.out.println("------------------------------------------------------------------------");
					System.out.println();
		            return null;
			}else {
				Patient forChange = null;
				int auxRow=0,auxCol=0;
				boolean breaki=true;
				for(int i=0;i<4;i++) {
	                for(int j=0;j<7;j++) {
	                    if(matAppointments[i][j]!=null) {

	                        if(matAppointments[i][j].getPrioridad() < 90&&breaki) {
	                            forChange = matAppointments[i][j];
	                            auxCol = j;
	                            auxRow = i;
	                            breaki=false;
	                        }
	                    }
	                }
	            }
	            if(breaki==false) {
	            	matAppointments[auxRow][auxCol] = p;
		            matAppointments[contRow][contCol] = forChange;
		            contCol++;
		            if (contCol == 7) {
		                contCol = 0;
		                contRow++;
		            }
		        	for(int i=0;i<4;i++) {
						for(int j=0;j<7;j++) {
							if(matAppointments[i][j]!=null) {
								System.out.print(matAppointments[i][j].getName()+"\t");
							}else {
								System.out.print(" 0 \t ");
							}
						}
						System.out.println();
						System.out.println();
					}
		        	System.out.println();
		            System.out.println("------------------------------------------------------------------------");
					System.out.println();
	            }else {
	            	  matAppointments[contRow][contCol] = p;
			            contCol++;
			            if (contCol == 7) {
			                contCol = 0;
			                contRow++;
			            }
			            for(int i=0;i<4;i++) {
							for(int j=0;j<7;j++) {
								if(matAppointments[i][j]!=null) {
									System.out.print(matAppointments[i][j].getName()+"\t");
								}else {
									System.out.print(" 0 \t ");
								}
							}
							System.out.println();
							System.out.println();

						}
			            System.out.println();
			            System.out.println("------------------------------------------------------------------------");
						System.out.println();
			            return null;
	            }
	            
				return forChange;
			}
			
			
		
		}

	}
}

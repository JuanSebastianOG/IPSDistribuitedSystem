package Class;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashMap;
import java.util.concurrent.locks.Lock;

import org.omg.CORBA._PolicyStub;

import Interfaces.InterfaceClient1;
import Interfaces.InterfaceEPS1;
import Interfaces.InterfaceINS;
import Interfaces.InterfaceIPS;

public class IPS implements InterfaceIPS {

	String myINSIP;
	HashMap<String, EPS1> epss = new HashMap<String, EPS1>();
	public int count = 0;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public void assignAppointment(Patient p) throws RemoteException, NotBoundException {
		// TODO Auto-generated method stub

		Thread assign = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub

				boolean valIPS = false;
				boolean valEPS = false;
				boolean valIPSUrg = false;

				EPS1 eps1 = epss.get(p.getEps());

				Registry registry;
				try {
					registry = LocateRegistry.getRegistry(myINSIP, 5554);
					InterfaceINS remINS = (InterfaceINS) registry.lookup("ins");

					if (eps1 != null) {
						Registry registrys = LocateRegistry.getRegistry(eps1.getIpEPS(), eps1.getPort());
						InterfaceEPS1 remEPS = (InterfaceEPS1) registrys.lookup("eps1");

						remEPS.addPatient(p);
						p.setPrioridad(remINS.evPatient(p));

						if (remINS.evPatient(p) < 70) {
							System.out.println("El paciente " + p.getName() + " no cumple puntos necesarios");

						} else {
							if (remINS.evPatient(p) > 90) {
								valIPSUrg = true;
								valIPS = true;
								System.out.println(
										"El paciente " + p.getName() + " esta grave > 90 cita al dia siguiente");
								System.out.println("Si no hay se reprograma a la del paciente con menor prioridad ");

								if (remEPS.haveCovert(p)) {
									valEPS = true;
								}
								// else
								// ABORT
							} else {
								valIPS = true;
								System.out.println("El paciente " + p.getName() + " cita normal");
								if (remEPS.haveCovert(p)) {
									valEPS = true;
								}

							}
						}

						if (valIPS && valEPS) {
							// Commit con synccro
							if (valIPSUrg) {
								System.out.println("COMMIT CITA URGENTE");
								Patient pMove = remEPS.setUrgAppointment(p);
								remINS.addCase(p);

								Registry registryPat = LocateRegistry.getRegistry(p.getIp(), p.getPortSC());
								InterfaceClient1 remPat = (InterfaceClient1) registryPat.lookup("client1");

								remPat.reciveNot(pMove, 1);
								remPat.reciveNot(p, 2);

								// Enviar mensaje de cambio de cita
							} else {
								System.out.println("COMMIT CITA NORMAL");
								Registry registryPat = LocateRegistry.getRegistry(p.getIp(), p.getPortSC());
								InterfaceClient1 remPat = (InterfaceClient1) registryPat.lookup("client1");
								remPat.reciveNot(p, 2);
								remEPS.setAppointment(p);
							}
							// Enviar mensaje a p de que se pudo agendar la cita
						} else {
							// aborts
							Registry registryPat = LocateRegistry.getRegistry(p.getIp(), p.getPortSC());
							InterfaceClient1 remPat = (InterfaceClient1) registryPat.lookup("client1");
							remPat.reciveNot(p, 3);
							System.out.println("ABORT");
						}

					} else {
						System.out.println("El paciente " + p.getName() + " no tiene eps asociada");
						System.out.println("ABORT");
					}

				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NotBoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});
		assign.start();

	}

	@Override
	public boolean createINS(String ip) throws RemoteException {
		// TODO Auto-generated method stub
		myINSIP = ip;
		return true;
	}

	@Override
	public boolean createEPS(EPS1 eps) throws RemoteException {

		// falta añadir a lista de eps
		this.epss.put(eps.getName(), eps);
		System.out.println("->" + eps.getIpEPS() + "->" + eps.getName());
		return true;
	}

}

package Class;

import java.io.Serializable;

public class Patient implements Serializable{

	String name;
	int document;
	int age; 
	String eps;
	String ip; 
	int prioridad;
	String plan;
	int portSC;

	public int getPortSC() {
		return portSC;
	}

	public void setPortSC(int portSC) {
		this.portSC = portSC;
	}

	public int getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}

	@Override
	public String toString() {
		return "Patient [name=" + name + ", document=" + document + ", age=" + age + ", eps=" + eps + ", ip=" + ip
				+ ", fiebre=" + fiebre + ", tos=" + tos + ", cansancio=" + cansancio + ", dolor=" + dolor
				+ ", faltaAire=" + faltaAire + ", insuficienciaPulmonar=" + insuficienciaPulmonar + ", shockSeptico="
				+ shockSeptico + ", fallaOrganica=" + fallaOrganica + ", otrasTatologias=" + otrasTatologias
				+ ", cirugias=" + cirugias + "]";
	}

	boolean fiebre; 
	boolean tos; 
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDocument() {
		return document;
	}

	public void setDocument(int document) {
		this.document = document;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEps() {
		return eps;
	}

	public void setEps(String eps) {
		this.eps = eps;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public boolean isFiebre() {
		return fiebre;
	}

	public void setFiebre(boolean fiebre) {
		this.fiebre = fiebre;
	}

	public boolean isTos() {
		return tos;
	}

	public void setTos(boolean tos) {
		this.tos = tos;
	}

	public boolean isCansancio() {
		return cansancio;
	}

	public void setCansancio(boolean cansancio) {
		this.cansancio = cansancio;
	}

	public boolean isDolor() {
		return dolor;
	}

	public void setDolor(boolean dolor) {
		this.dolor = dolor;
	}

	public boolean isFaltaAire() {
		return faltaAire;
	}

	public void setFaltaAire(boolean faltaAire) {
		this.faltaAire = faltaAire;
	}

	public boolean isInsuficienciaPulmonar() {
		return insuficienciaPulmonar;
	}

	public void setInsuficienciaPulmonar(boolean insuficienciaPulmonar) {
		this.insuficienciaPulmonar = insuficienciaPulmonar;
	}

	public boolean isShockSeptico() {
		return shockSeptico;
	}

	public void setShockSeptico(boolean shockSeptico) {
		this.shockSeptico = shockSeptico;
	}

	public boolean isFallaOrganica() {
		return fallaOrganica;
	}

	public void setFallaOrganica(boolean fallaOrganica) {
		this.fallaOrganica = fallaOrganica;
	}

	public boolean isOtrasTatologias() {
		return otrasTatologias;
	}

	public void setOtrasTatologias(boolean otrasTatologias) {
		this.otrasTatologias = otrasTatologias;
	}

	public boolean isCirugias() {
		return cirugias;
	}

	public void setCirugias(boolean cirugias) {
		this.cirugias = cirugias;
	}

	boolean cansancio; 
	boolean dolor; 
	boolean faltaAire; 
	boolean insuficienciaPulmonar;
	boolean shockSeptico;
	boolean fallaOrganica; 
	boolean otrasTatologias; 
	boolean cirugias;
	
	public Patient(String name, int document, int age, String eps, String ip, boolean fiebre, boolean tos,
			boolean cansancio, boolean dolor, boolean faltaAire, boolean insuficienciaPulmonar, boolean shockSeptico,
			boolean fallaOrganica, boolean otrasTatologias, boolean cirugias,String plan) {
		super();
		this.name = name;
		this.document = document;
		this.age = age;
		this.eps = eps;
		this.ip = ip;
		this.fiebre = fiebre;
		this.tos = tos;
		this.cansancio = cansancio;
		this.dolor = dolor;
		this.faltaAire = faltaAire;
		this.insuficienciaPulmonar = insuficienciaPulmonar;
		this.shockSeptico = shockSeptico;
		this.fallaOrganica = fallaOrganica;
		this.otrasTatologias = otrasTatologias;
		this.cirugias = cirugias;
		this.plan=plan;
	}

	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}
	
	
}

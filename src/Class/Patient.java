package Class;

public class Patient {

	String name;
	int document;
	int age; 
	String eps;
	int ip; 
	
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
	boolean cansancio; 
	boolean dolor; 
	boolean faltaAire; 
	boolean insuficienciaPulmonar;
	boolean shockSeptico;
	boolean fallaOrganica; 
	boolean otrasTatologias; 
	boolean cirugias;
	
	public Patient(String name, int document, int age, String eps, int ip, boolean fiebre, boolean tos,
			boolean cansancio, boolean dolor, boolean faltaAire, boolean insuficienciaPulmonar, boolean shockSeptico,
			boolean fallaOrganica, boolean otrasTatologias, boolean cirugias) {
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
	}
	
	
}

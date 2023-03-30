
public class Pronostico {
	
	private Equipo equipo1;
	
	private Equipo equipo2;
	
	private int ganaEquipo1;
	
	private int empate;
	
	private int ganaEquipo2;
	
	public void setPronostico(Equipo equipo1,Equipo equipo2,int ganaEquipo1,int empate,int ganaEquipo2) {
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
		this.ganaEquipo1 = ganaEquipo1;
		this.ganaEquipo2 = ganaEquipo2;
		this.empate = empate;
	}
	
	public Equipo getEquipo1() {
		return equipo1;
	}
	

	public Equipo getEquipo2() {
		return equipo2;
	}

	public int getGanaEquipo1() {
		return ganaEquipo1;
	}

	public int getEmpate() {
		return empate;
	}

	public int getGanaEquipo2() {
		return ganaEquipo2;
	}

		
}

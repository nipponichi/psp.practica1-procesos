package serviciosProcesos;

public class Auxiliares {
	
	//Variables comunes
	public long tiempoTotal;
	public long tiempoFinal;
	public long tiempoProceso;
	public long tiempoInicio;
	public int quantum = 50;
	
	//Procesos comunes
	public Proceso proceso1 = new Proceso("P1", 200);
	public Proceso proceso2 = new Proceso("P2", 300);
	public Proceso proceso3 = new Proceso("P3", 400);
	public Proceso proceso4 = new Proceso("P4", 200);
	
	
	public long getTiempoFinal() {
		tiempoFinal = System.currentTimeMillis();
		return tiempoFinal;
	}
	
	public long getTiempoInicio() {
		tiempoInicio = System.currentTimeMillis();
		return tiempoInicio;
	}
	
	
	
	

}

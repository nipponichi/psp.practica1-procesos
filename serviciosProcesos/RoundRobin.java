package serviciosProcesos;

import java.util.ArrayList;

public class RoundRobin {
	
	ArrayList <Proceso> procesoList = new ArrayList<>();
	
	Proceso proceso1 = new Proceso("P1", 200);
	Proceso proceso2 = new Proceso("P2", 300);
	Proceso proceso3 = new Proceso("P3", 400);
	Proceso proceso4 = new Proceso("P4", 200);
	
	long tiempoTotal;
	int quantum = 50;
	int loop = 1;
	
	public void resolucionProceso() {

		procesoList.add(proceso1);
		procesoList.add(proceso2);
		procesoList.add(proceso3);
		procesoList.add(proceso4);
	    
	    // Con for recorremos las posiciones de la colección para procesar los procesos.
		do { 
			
			for (int i = 0; i < procesoList.size(); i++) {
				long tiempoInicio = System.currentTimeMillis();
	        
				//Consumimos el tiempo de proceso a modo de sleep.
				try {

					procesoList.get(i).setDuracion(procesoList.get(i).getDuracion() - quantum);

	        	
					Thread.sleep(quantum);
	        
				} catch (InterruptedException ex) {
	        	
					Thread.currentThread().interrupt();
	        	
				}
	
				long tiempoFinal = System.currentTimeMillis();
				long tiempoProceso = tiempoFinal - tiempoInicio;
	        
				//Mostramos el tiempo de procesamiento de cada proceso y su orden
				System.out.println(procesoList.get(i).getNombre() + " -> Procesamiento: " + procesoList.get(i).getDuracion()+" ms");
				tiempoTotal += tiempoProceso;
				
				//Eliminamos el registro de la coleccion si la duracion es 0 o inferior.
				if (procesoList.get(i).getDuracion() <= 0) {	
					procesoList.remove(i);
					i--;
				}
			}
			
			System.out.println("Loop numero: "+loop);
			loop++;
		
		//Comprobamos si la coleccion está vacía para abandonar el bucle 
		} while (!procesoList.isEmpty());
		
		//Tiempo total del proceso
		System.out.println("Tiempo total de procesamiento: " + tiempoTotal + " ms");
	}
}

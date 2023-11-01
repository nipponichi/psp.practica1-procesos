package serviciosProcesos;

import java.util.ArrayList;

public class RoundRobin extends Auxiliares {
	
	ArrayList <Proceso> procesoList = new ArrayList<>();
	int loop = 1;
	
	public void resolucionProceso() {

		procesoList.add(proceso1);
		procesoList.add(proceso2);
		procesoList.add(proceso3);
		procesoList.add(proceso4);
	    
	    // Con for recorremos las posiciones de la colección para procesar los procesos.
		do { 
			
			for (int i = 0; i < procesoList.size(); i++) {
				
				getTiempoInicio();
	        
				//Consumimos el tiempo de proceso a modo de sleep y restamos el tiempo quantum de la duracion del proceso.
				try {

					procesoList.get(i).setDuracion(procesoList.get(i).getDuracion() - quantum);
					Thread.sleep(quantum);
	        
				} catch (InterruptedException ex) {
	        	
					Thread.currentThread().interrupt();
	        	
				}
	
				getTiempoFinal();
				
				tiempoProceso = tiempoFinal - tiempoInicio;
	        
				//Mostramos el tiempo de procesamiento de cada proceso y su orden
				System.out.println(procesoList.get(i).getNombre() + " -> Procesamiento: " + procesoList.get(i).getDuracion()+" ms");
				tiempoTotal += tiempoProceso;
				
				//Eliminamos el registro de la coleccion si la duracion es 0 o inferior.
				if (procesoList.get(i).getDuracion() <= 0) {	
					procesoList.remove(i);
					i--;
				}
			}
			
			//Mostramos el número de vuelta
			System.out.println("Loop numero: "+loop);
			loop++;
		
		//Comprobamos si la colección está vacía para abandonar el bucle 
		} while (!procesoList.isEmpty());
		
		//Tiempo total del proceso
		System.out.println("Tiempo total de procesamiento: " + tiempoTotal + " ms");
	}
}

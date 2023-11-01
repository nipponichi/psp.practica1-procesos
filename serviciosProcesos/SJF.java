package serviciosProcesos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SJF {
	
	ArrayList <Proceso> procesoList = new ArrayList<>();
	
	Proceso proceso1 = new Proceso("P1", 200);
	Proceso proceso2 = new Proceso("P2", 300);
	Proceso proceso3 = new Proceso("P3", 400);
	Proceso proceso4 = new Proceso("P4", 200);
	
	
	public void resolucionProceso() {
		
	    
		procesoList.add(proceso1);
		procesoList.add(proceso2);
		procesoList.add(proceso3);
		procesoList.add(proceso4);
		
	
		/*Con Comparator, realizamos una comparacion de getDuracion(), seleccionando los mas cortos
		para colocarlos con Collections en el orden deseado.*/
		Collections.sort(procesoList, new Comparator<Proceso>() {
	        @Override
	        public int compare(Proceso proceso1, Proceso proceso2) {
	            return proceso1.getDuracion().compareTo(proceso2.getDuracion());
	        }
	    });
	    
	    long tiempoTotal = 0;
	
	    // Con foreach recorremos las posiciones de la colección para procesar los procesos.	
	    for (Proceso proceso : procesoList) {
	        long tiempoInicio = System.currentTimeMillis();
	        
	        //Consumimos el tiempo de proceso a modo de sleep.
	        try {
	            Thread.sleep(proceso.getDuracion());
	        } catch (InterruptedException ex) {
	        	Thread.currentThread().interrupt();
	        }
	
	        long tiempoFinal = System.currentTimeMillis();
	        long tiempoProceso = tiempoFinal - tiempoInicio;
	        
	        //Mostramos el tiempo de procesamiento de cada proceso y su orden
	        System.out.println(proceso.getNombre() + " -> Procesamiento: " + proceso.getDuracion()+" ms");
	        tiempoTotal += tiempoProceso;
	    }
	    //Tiempo total del proceso
	    System.out.println("Tiempo total de procesamiento: " + tiempoTotal + " ms");
	}
}




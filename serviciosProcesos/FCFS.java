package serviciosProcesos;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class FCFS {
	
	
	Map<String, Integer> procesoFCFS = new LinkedHashMap<String, Integer>();
	
	Proceso proceso1 = new Proceso("P1", 200);
	Proceso proceso2 = new Proceso("P2", 300);
	Proceso proceso3 = new Proceso("P3", 400);
	Proceso proceso4 = new Proceso("P4", 200);
	
	long tiempoTotal;
	
	public void resolucionProceso() {

		// LinkedHashMap muestra los procesos ordenados como los recibe, como FCFS.
	    Map<String, Integer> procesoFCFS = new LinkedHashMap<>();

	    procesoFCFS.put(proceso2.getNombre(), proceso2.getDuracion());
	    procesoFCFS.put(proceso1.getNombre(), proceso1.getDuracion());
	    procesoFCFS.put(proceso3.getNombre(), proceso3.getDuracion());
	    procesoFCFS.put(proceso4.getNombre(), proceso4.getDuracion());
	    
	    // Con foreach recorremos las posiciones de la colección para procesar los procesos.	    
	    for (Entry<String, Integer> entry : procesoFCFS.entrySet()) {
	        String clave = entry.getKey();
	        Integer valor = entry.getValue();
	        
	        long tiempoInicio = System.currentTimeMillis();
	        
	        //Consumimos el tiempo de proceso a modo de sleep.
	        try {
	            Thread.sleep(valor);
	        } catch (InterruptedException ex) {
	        	Thread.currentThread().interrupt();
	        }

	        long tiempoFinal = System.currentTimeMillis();
	        long tiempoProceso = tiempoFinal - tiempoInicio;
	        
	        //Mostramos el tiempo de procesamiento de cada proceso y su orden
	        System.out.println(clave + " -> Procesamiento: " + tiempoProceso + " ms");
	        tiempoTotal += tiempoProceso;
	    }
	    //Tiempo total del proceso
	    System.out.println("Tiempo total de procesamiento: " + tiempoTotal + " ms");
	}
}


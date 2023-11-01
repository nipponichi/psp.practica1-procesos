package serviciosProcesos;

import java.util.Scanner;

public class Menu {
	
	
	Menu(){
		
	}
	
	public void menuInicial() {
		int seleccion;
		boolean esMenu = false;
		Scanner sc = new Scanner(System.in);
		
		do {
		System.out.println("Selecciona una opcion:"
				+ "\n1. - FCFS"
				+ "\n2. - SJF"
				+ "\n3. - Round Robin"
				+ "\n4. - Salir");
		
			seleccion = sc.nextInt();
		
			switch(seleccion) {
				case 1:
					System.out.println("FCFS"
							+ " - First Come First Served");
					FCFS fcfs = new FCFS();
					fcfs.resolucionProceso();
					esMenu = true;
					break;
				case 2:
					System.out.println("SJF"
							+ " - Short Job First");
					SJF sfj = new SJF();
					sfj.resolucionProceso();
					esMenu = true;
					break;
				case 3:
					System.out.println("Round Robin");
					RoundRobin rr = new RoundRobin();
					rr.resolucionProceso();
					esMenu = true;
					break;
				case 4:
					cerrarPrograma();
				default:
					System.out.println("Selecciona una opcion valida");
					esMenu = true;
			}
		}while(esMenu);
		sc.close();
	}
	
	private void cerrarPrograma() {
		System.out.println("Gracias por utilizar nuestro software");
		System.exit(0);
	}

}

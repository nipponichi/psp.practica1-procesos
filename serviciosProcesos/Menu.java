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
					System.out.println("FCFS");
					//FCFS fcfs = new FCFS();
					break;
				case 2:
					System.out.println("SJF");
					//SJF sfj = new SJF();
					break;
				case 3:
					System.out.println("Round Robin");
					//RoundRobin rr = new RoundRobin();
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

package serviciosProcesos;

public class Proceso {

	private String nombre;
	private Integer duracion;
	
	Proceso (){
		
	}
	
	Proceso (String nombre, Integer duracion){
		this.nombre = nombre;
		this.duracion = duracion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getDuracion() {
		return duracion;
	}

	public void setDuracion(Integer duracion) {
	        this.duracion = duracion;
	}
	
}

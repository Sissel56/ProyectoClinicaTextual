package clases.clinica;

import java.time.LocalDateTime;

public class Intervencion extends Cita {
	private int duracion;
	
	
	//Constructor
	public Intervencion() {
		super();
	}

	public Intervencion(Long iD, LocalDateTime fechaYHora, int duracion) {
		super(iD, fechaYHora);
		this.duracion = duracion;
	}
	//Getters y Setters
	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	
	//ToString
	@Override
	public String toString() {
		return "Intervencion [duracion=" + duracion + ", ID=" + ID + ", fechaYHora=" + fechaYHora + "]";
	}

	
}

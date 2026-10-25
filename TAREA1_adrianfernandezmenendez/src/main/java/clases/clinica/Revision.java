package clases.clinica;

import java.time.LocalDateTime;

public class Revision extends Cita {
	private String anotaciones;
	
	
	//Constructores
	public Revision() {
		super();
	}

	public Revision(Long iD, LocalDateTime fechaYHora, String anotaciones) {
		super(iD, fechaYHora);
		this.anotaciones = anotaciones;
	}
	
	//Getters y Setters
	public String getAnotaciones() {
		return anotaciones;
	}

	public void setAnotaciones(String anotaciones) {
		this.anotaciones = anotaciones;
	}

	//ToString
	@Override
	public String toString() {
		return "Revision [anotaciones=" + anotaciones + ", ID=" + ID + ", fechaYHora=" + fechaYHora + "]";
	}
}

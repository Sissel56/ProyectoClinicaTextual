package clases.clinica;

import java.time.LocalDateTime;

public class Revision extends Cita {

	// Constructores
	public Revision() {
		super();
	}

	public Revision(Long id, LocalDateTime fechaYHora, String anotaciones) {
		super(id, fechaYHora, anotaciones);
	}

	// Getters y Setters
	public String getAnotaciones() {
		return anotaciones;
	}

	public void setAnotaciones(String anotaciones) {
		this.anotaciones = anotaciones;
	}

	// ToString
	@Override
	public String toString() {
		return "Revision [anotaciones=" + anotaciones + ", ID=" + id + ", fechaYHora=" + fechaYHora + "]";
	}
}

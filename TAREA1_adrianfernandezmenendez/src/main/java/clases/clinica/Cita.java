package clases.clinica;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Cita {
	protected Long id;
	protected LocalDateTime fechaYHora;
	protected String anotaciones;

	// Carga pesada
	protected Tratamiento tratamiento;

	// Carga ligera
	protected Long idTratamiento;

	// Constructores
	public Cita() {
	}

	public Cita(Long iD, LocalDateTime fechaYHora, String anotaciones) {
		super();
		fechaYHora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
		id = iD;
		this.anotaciones = anotaciones;
		this.fechaYHora = fechaYHora;
	}

	// Getters y Setters
	public Long getID() {
		return id;
	}

	public void setID(Long iD) {
		id = iD;
	}

	public LocalDateTime getFechaYHora() {
		return fechaYHora;
	}

	public void setFechaYHora(LocalDateTime fechaYHora) {
		fechaYHora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
		this.fechaYHora = fechaYHora;
	}

	public Tratamiento getTratamiento() {
		return tratamiento;
	}

	public void setTratamiento(Tratamiento tratamiento) {
		this.tratamiento = tratamiento;
	}

	public Long getIdTratamiento() {
		return idTratamiento;
	}

	public void setIdTratamiento(Long idTratamiento) {
		this.idTratamiento = idTratamiento;
	}

	public String getAnotaciones() {
		return anotaciones;
	}

	public void setAnotaciones(String anotaciones) {
		this.anotaciones = anotaciones;
	}

	// ToString
	@Override
	public String toString() {
		return "Cita [ID=" + id + ", fechaYHora=" + fechaYHora + ", anotaciones=" + anotaciones + ", tratamiento="
				+ tratamiento + ", idTratamiento=" + idTratamiento + "]";
	}

}

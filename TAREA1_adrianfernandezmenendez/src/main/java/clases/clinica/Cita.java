package clases.clinica;

import java.time.LocalDateTime;

public abstract class Cita {
	protected Long ID;
	protected LocalDateTime fechaYHora;
	
	//Carga pesada
	protected Tratamiento tratamiento;
	
	//Carga ligera
	protected Long idTratamiento;
	
	
	//Constructores
	public Cita() {
	}

	public Cita(Long iD, LocalDateTime fechaYHora) {
		super();
		ID = iD;
		this.fechaYHora = fechaYHora;
	}
	
	
	//Getters y Setters
	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public LocalDateTime getFechaYHora() {
		return fechaYHora;
	}

	public void setFechaYHora(LocalDateTime fechaYHora) {
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
	
	//ToString
	@Override
	public String toString() {
		return "Cita [ID=" + ID + ", fechaYHora=" + fechaYHora + "]";
	}
}

package clases.clinica;

import java.time.LocalDate;
import java.util.Set;

public class Tratamiento{
	private Long ID;
	private String nombre;
	private LocalDate fechaIni = LocalDate.now();
	private boolean consentimiento = false;
	
	//Carga pesada 
	private Paciente paciente;
	private Set<Cita> citas;
	
	//Carga ligera
	private Long idpaciente;
	private Set<Long> idCitas;
	
	//Constructor
	public Tratamiento() {

	}

	public Tratamiento(Long iD, String nombre, LocalDate fechaIni, boolean consentimiento, Long idpaciente) {
		this.ID = iD;
		this.nombre = nombre;
		this.fechaIni = fechaIni;
		this.consentimiento = consentimiento;
		this.idpaciente = idpaciente;
	}
	
	
	//Getters y Setters
	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechaIni() {
		return fechaIni;
	}

	public void setFechaIni(LocalDate fechaIni) {
		this.fechaIni = fechaIni;
	}

	public boolean isConsentimiento() {
		return consentimiento;
	}

	public void setConsentimiento(boolean consentimiento) {
		this.consentimiento = consentimiento;
	}

	public Long getIdpaciente() {
		return idpaciente;
	}

	public void setIdpaciente(Long idpaciente) {
		this.idpaciente = idpaciente;
	}
	
	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	public Set<Cita> getCitas() {
		return citas;
	}

	public void setCitas(Set<Cita> citas) {
		this.citas = citas;
	}

	public Set<Long> getIdCitas() {
		return idCitas;
	}

	public void setIdCitas(Set<Long> idCitas) {
		this.idCitas = idCitas;
	}

	//ToString
	@Override
	public String toString() {
		return "Tratamiento [ID=" + ID + ", nombre=" + nombre + ", fechaIni=" + fechaIni + ", consentimiento="
				+ consentimiento;
	}

}

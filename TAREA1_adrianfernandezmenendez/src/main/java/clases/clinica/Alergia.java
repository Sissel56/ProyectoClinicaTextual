package clases.clinica;

import java.io.Serializable;

public class Alergia implements Serializable {
	private Long id;
	private String nombre;

	// Cargas de historiales
	private HistorialAlergia relacion;

	// Carga pesada Alergia:Medicamento
	private Medicamento medicamento;

	// Carga ligera Alergia:Medicamento
	private Long idMedicamento;

	// Constructores
	public Alergia() {
	}

	public Alergia(Long iD, String nombre) {
		id = iD;
		this.nombre = nombre;
	}

	// Getters y Setters

	public Long getIdMedicamento() {
		return idMedicamento;
	}

	public void setIdMedicamento(Long idMedicamento) {
		this.idMedicamento = idMedicamento;
	}

	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

	public HistorialAlergia getRelacion() {
		return relacion;
	}

	public void setRelacion(HistorialAlergia relacion) {
		this.relacion = relacion;
	}

	public Long getID() {
		return id;
	}

	public void setID(Long iD) {
		id = iD;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	// ToString
	@Override
	public String toString() {
		return "Alergia [ID=" + id + ", nombre=" + nombre + "]";
	}

}

package clases.clinica;

public class Alergia {
	private Long ID;
	private String nombre;
	
	//Cargas de historiales
	private HistorialAlergia relacion;
	
	//Carga pesada Alergia:Medicamento
	private Medicamento medicamento;
	
	//Carga ligera Alergia:Medicamento
	private Long idMedicamento;

	//Constructores
	public Alergia() {
	}

	public Alergia(Long iD, String nombre) {
		ID = iD;
		this.nombre = nombre;
	}
	
	
	//Getters y Setters
	
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
	
	//ToString
	@Override
	public String toString() {
		return "Alergia [ID=" + ID + ", nombre=" + nombre + "]";
	}
	
	

}

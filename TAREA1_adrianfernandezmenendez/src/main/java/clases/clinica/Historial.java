package clases.clinica;

public class Historial {
	private Long id;
	private String desc;

	// Cargas de alergias
	private HistorialAlergia relacion;

	// Carga pesada Paciente
	private Paciente paciente;

	// Carga ligera Paciente
	private Long idPaciente;

	// Constructors
	public Historial() {
	}

	public Historial(Long ID, String desc) {
		this.id = ID;
		this.desc = desc;
	}

	// Getters y Setters

	public Long getID() {
		return id;
	}

	public void setID(Long iD) {
		id = iD;
	}

	public HistorialAlergia getRelacion() {
		return relacion;
	}

	public void setRelacion(HistorialAlergia relacion) {
		this.relacion = relacion;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Long getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(Long idPaciente) {
		this.idPaciente = idPaciente;
	}

	// ToString
	@Override
	public String toString() {
		return "Historial [ID=" + id + ", desc=" + desc + "]";
	}

}

package clases.clinica;

public class Medicamento {
	private Long id;
	private String nombre;
	private String principioActivo;
	private float dosisMax;

	// Carga pesada
	private Alergia alergia;

	// Carga ligera
	private Long idAlergia;

	public Medicamento() {
	}

	public Medicamento(String nombre, String principioActivo, float dosisMax) {
		this.nombre = nombre;
		this.principioActivo = principioActivo;
		this.dosisMax = dosisMax;
	}

	public Medicamento(Long iD, String nombre, String principioActivo, float dosisMax) {
		id = iD;
		this.nombre = nombre;
		this.principioActivo = principioActivo;
		this.dosisMax = dosisMax;
	}

	// Getters y Setters

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

	public String getPrincipioActivo() {
		return principioActivo;
	}

	public void setPrincipioActivo(String principioActivo) {
		this.principioActivo = principioActivo;
	}

	public float getDosisMax() {
		return dosisMax;
	}

	public void setDosisMax(float dosisMax) {
		this.dosisMax = dosisMax;
	}

	public Alergia getAlergia() {
		return alergia;
	}

	public void setAlergia(Alergia alergia) {
		this.alergia = alergia;
	}

	public Long getIdAlergia() {
		return idAlergia;
	}

	public void setIdAlergia(Long idAlergia) {
		this.idAlergia = idAlergia;
	}

	// ToString

	@Override
	public String toString() {
		return "Medicamento [ID=" + id + ", nombre=" + nombre + ", principioActivo=" + principioActivo + ", dosisMax="
				+ dosisMax + "]";
	}

}

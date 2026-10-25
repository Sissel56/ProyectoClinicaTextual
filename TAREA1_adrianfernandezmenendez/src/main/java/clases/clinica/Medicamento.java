package clases.clinica;

public class Medicamento {
	private Long ID;
	private String nombre;
	private String principioActivo;
	private float dosisMax;
	
	//Carga pesada
	private Alergia alergia;
	
	//Carga ligera
	private Long idAlergia;
	
	public Medicamento() {
	}

	public Medicamento(Long iD, String nombre, String principioActivo, float dosisMax) {
		ID = iD;
		this.nombre = nombre;
		this.principioActivo = principioActivo;
		this.dosisMax = dosisMax;
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
	
	//ToString

	@Override
	public String toString() {
		return "Medicamento [ID=" + ID + ", nombre=" + nombre + ", principioActivo=" + principioActivo + ", dosisMax="
				+ dosisMax + "]";
	}

}

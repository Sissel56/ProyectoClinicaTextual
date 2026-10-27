package clases.clinica;

import java.time.LocalDate;
import java.util.Set;

public class Paciente {
	private Long id;
	private String nombre;
	private LocalDate fechaNac;
	private String tlfno;
	private String email;
	private String direccion;
	private String nif;

	// Carga pesada
	private Set<Tratamiento> tratamientos;
	private Historial historial;
	// Carga ligera
	private Set<Long> idTratamientos;
	private Long idHistorial;

	// Constructores
	public Paciente() {

	}

	public Paciente(Long id, String nombre, LocalDate fechaNac, String tlfno, String email, String direccion,
			String nif) {
		this.id = id;
		this.nombre = nombre;
		this.fechaNac = fechaNac;
		this.tlfno = tlfno;
		this.email = email;
		this.direccion = direccion;
		this.nif = nif;
	}

	// Getters y Setters
	public Long getID() {
		return id;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public Set<Tratamiento> getTratamientos() {
		return tratamientos;
	}

	public void setTratamientos(Set<Tratamiento> tratamientos) {
		this.tratamientos = tratamientos;
	}

	public Historial getHistorial() {
		return historial;
	}

	public void setHistorial(Historial historial) {
		this.historial = historial;
	}

	public Set<Long> getIdTratamientos() {
		return idTratamientos;
	}

	public void setIdTratamientos(Set<Long> idTratamientos) {
		this.idTratamientos = idTratamientos;
	}

	public Long getIdHistorial() {
		return idHistorial;
	}

	public void setIdHistorial(Long idHistorial) {
		this.idHistorial = idHistorial;
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

	public LocalDate getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getTlfno() {
		return tlfno;
	}

	public void setTlfno(String tlfno) {
		this.tlfno = tlfno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNIF() {
		return nif;
	}

	public void setNIF(String nif) {
		this.nif = nif;
	}

	// ToString
	@Override
	public String toString() {
		return "Paciente [ID=" + id + ", nombre=" + nombre + ", fechaNac=" + fechaNac + ", tlfno=" + tlfno + ", email="
				+ email + ", direccion=" + direccion + ", nif=" + nif + "]";
	}

}

package clases.empleado;

import java.util.Set;

public class Cirujano extends Empleado{
	private Set<Especialidad> especialidades;

	public Cirujano() {
	}

	public Cirujano(Long id, String nombre, String apellidos, String telefono, String email, String nif,
			String direccion) {
		super(id, nombre, apellidos, telefono, email, nif, direccion);
	}

	public Set<Especialidad> getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(Set<Especialidad> especialidades) {
		this.especialidades = especialidades;
	}

	@Override
	public String toString() {
		return "Cirujano [especialidades=" + especialidades + ", id=" + id + ", nombre=" + nombre + ", apellidos="
				+ apellidos + ", telefono=" + telefono + ", email=" + email + ", nif=" + nif + ", direccion="
				+ direccion + "]";
	}
}

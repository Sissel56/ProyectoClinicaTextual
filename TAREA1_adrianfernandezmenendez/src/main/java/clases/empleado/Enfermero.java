package clases.empleado;

public class Enfermero extends Empleado {
	private CategoriaEnfermero categoria;

	public Enfermero() {

	}
	
	public Enfermero(CategoriaEnfermero categoria) {
		super();
		this.categoria = categoria;
	}

	public Enfermero(Long id, String nombre, String apellidos, String telefono, String email, String nif,
			String direccion) {
		super(id, nombre, apellidos, telefono, email, nif, direccion);
	}

	public CategoriaEnfermero getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaEnfermero categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Enfermeria [categoria=" + categoria + ", id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos
				+ ", telefono=" + telefono + ", email=" + email + ", nif=" + nif + ", direccion=" + direccion + "]";
	}

}

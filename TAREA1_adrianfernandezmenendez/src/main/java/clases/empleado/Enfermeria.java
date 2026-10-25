package clases.empleado;

public class Enfermeria extends Empleado{
	private CategoriaEnfermeria categoria;

	public Enfermeria() {
		
	}

	public Enfermeria(Long id, String nombre, String apellidos, String telefono, String email, String nif,
			String direccion) {
		super(id, nombre, apellidos, telefono, email, nif, direccion);
	}

	public CategoriaEnfermeria getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaEnfermeria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Enfermeria [categoria=" + categoria + ", id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos
				+ ", telefono=" + telefono + ", email=" + email + ", nif=" + nif + ", direccion=" + direccion + "]";
	}
	
}

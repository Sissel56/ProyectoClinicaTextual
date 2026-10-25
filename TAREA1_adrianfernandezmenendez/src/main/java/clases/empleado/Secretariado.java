package clases.empleado;

public class Secretariado extends Empleado{
	private int numanos;

	public Secretariado() {
	}

	public Secretariado(Long id, String nombre, String apellidos, String telefono, String email, String nif,
			String direccion) {
		super(id, nombre, apellidos, telefono, email, nif, direccion);
	}

	public int getNumanos() {
		return numanos;
	}

	public void setNumanos(int numanos) {
		this.numanos = numanos;
	}

	@Override
	public String toString() {
		return "Secretariado [numanos=" + numanos + ", id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos
				+ ", telefono=" + telefono + ", email=" + email + ", nif=" + nif + ", direccion=" + direccion + "]";
	}
	
}
